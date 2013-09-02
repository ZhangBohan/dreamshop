package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.utils.Pager;
import nengzhe.AbstractSpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: bohan
 * Date: 8/25/13
 * Time: 8:18 PM
 */
public class GoodsServiceTest extends AbstractSpringTests {
    @Autowired
    private GoodsService goodsService;
    @Test
    public void testGetGoodsList() throws Exception {
        User user = new User();
        user.setId(1);
        List<Goods> list =  this.goodsService.getGoodsList(new GoodsSearch(), new Pager(), user);
        System.out.println(list);
    }

    @Test
    public void testGetGoods() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
