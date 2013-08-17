package me.nengzhe.goods.service;

import me.nengzhe.goods.dao.GoodsDao;
import me.nengzhe.goods.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午3:28
 */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Transactional
    public Goods getGoods(Integer id) {
        Goods goods = this.goodsDao.get(id);

        return goods;
    }
}
