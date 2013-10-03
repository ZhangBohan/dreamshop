package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.exception.LogicException;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.base.exception.ResourceNotFoundException;
import me.nengzhe.base.exception.UnauthorizedException;
import me.nengzhe.goods.dao.GoodsDao;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.base.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午3:28
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public List<Goods> getGoodsList(GoodsSearch search, Pager pager, User user)
            throws NotImplException {
        List<Goods> list = this.goodsDao.getList(search, pager, user);
        Integer count = this.goodsDao.getCount(search, user);
        pager.setTotal(count);

        return list;
    }

    public Goods getGoods(String barCode) {
        Goods goods = this.goodsDao.get(barCode);
        return goods;
    }

    public Goods getGoods(int id, User user) {
        Goods goods = this.goodsDao.get(id);
        if(goods == null || !user.getCompanyId().equals(goods.getCompanyId())) {
            // 非法操作
            throw new ResourceNotFoundException();
        }
        return goods;
    }

    public void add(Goods goods, User user) throws LogicException {
        goods.init();
        goods.setCompanyId(user.getCompanyId());
        try {
            this.goodsDao.insert(goods);
        } catch (DuplicateKeyException e) {
            throw new LogicException("该条码已存在！");
        }
    }

    public void update(Goods goods, User user) {
        Goods originGoods = this.goodsDao.get(goods.getId());
        if(!user.getCompanyId().equals(originGoods.getCompanyId())) {
            // 非法操作
            throw new ResourceNotFoundException();
        }
        goods.setCreateAt(originGoods.getCreateAt());
        goods.setDeleted(originGoods.getDeleted());
        goods.setCompanyId(originGoods.getCompanyId());
        goods.setModifiedAt(new Date());
        this.goodsDao.update(goods);
    }

    public void delete(Integer id, User user) {
        Goods goods = this.getGoods(id, user);
        goods.setDeleted(true);
        goods.setModifiedAt(new Date());

        this.update(goods, user);
    }
}
