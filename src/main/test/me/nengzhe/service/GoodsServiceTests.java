package me.nengzhe.service;

import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午5:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class GoodsServiceTests {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void testGetGoods() {
        Integer id = 1;
        Goods goods = this.goodsService.getGoods(id);
        Assert.notNull(goods);
    }
}
