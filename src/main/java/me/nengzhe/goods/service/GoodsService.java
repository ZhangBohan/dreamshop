package me.nengzhe.goods.service;

import me.nengzhe.goods.dao.GoodsDao;
import me.nengzhe.goods.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午3:28
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public Goods getGoods(String barCode) {
        Goods goods = this.goodsDao.get(barCode);
        return goods;
    }

    public void insert(Goods goods) {
        goods.init();
        this.goodsDao.insert(goods);
    }

    public void update(Goods goods) {
        goods.setModifiedAt(new Date());
        this.goodsDao.update(goods);
    }

    public void delete(Integer id) {
        this.goodsDao.delete(id);
    }
}
