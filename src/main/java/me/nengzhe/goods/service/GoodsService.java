package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.dao.GoodsDao;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Goods> getGoodsList(GoodsSearch search, Pager pager) throws NotImplException {
        List<Goods> list = this.goodsDao.getList(search, pager);
        Integer count = this.goodsDao.getCount(search);
        pager.setTotal(count);

        return list;
    }

    public Goods getGoods(String barCode) {
        Goods goods = this.goodsDao.get(barCode);
        return goods;
    }

    public Goods getGoods(int id) {
        Goods goods = this.goodsDao.get(id);
        return goods;
    }

    public void add(Goods goods, User user) {
        goods.init();
        goods.setCompanyId(user.getCompanyId());
        this.goodsDao.insert(goods);
    }

    public void update(Goods goods, User user) {
        goods.setModifiedAt(new Date());
        this.goodsDao.update(goods);
    }

    public void delete(Integer id) {
        this.goodsDao.delete(id);
    }
}
