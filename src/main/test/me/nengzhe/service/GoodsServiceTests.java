package me.nengzhe.service;

import junit.framework.TestCase;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午5:23
 */
public class GoodsServiceTests extends TestCase {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void testGetGoods() {
        Integer id = 1;
        Goods goods = this.goodsService.getGoods(id);
        Assert.notNull(goods);
    }
}
