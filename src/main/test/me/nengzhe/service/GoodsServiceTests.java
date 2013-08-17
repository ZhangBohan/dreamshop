package me.nengzhe.service;

import me.nengzhe.goods.service.GoodsService;
import me.nengzhe.utils.AbstractSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午5:23
 */
public class GoodsServiceTests extends AbstractSpringTest {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void testGetGoods() {
        String barCode = "0000";
        this.goodsService.getGoods(barCode);
    }
}
