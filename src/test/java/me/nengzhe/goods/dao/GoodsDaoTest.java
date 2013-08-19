package me.nengzhe.goods.dao;

import me.nengzhe.goods.model.Goods;
import nengzhe.AbstractSpringTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * User: bohan
 * Date: 8/19/13
 * Time: 4:50 PM
 */
public class GoodsDaoTest extends AbstractSpringTests {
    @Autowired
    private GoodsDao goodsDao;

    private Goods goods;

    @Before
    public void setUp() throws Exception {
        goods = new Goods();
        goods.setName("商品名称");
        goods.setBarCode("test");
        goods.setPrice(new BigDecimal(1));
        goods.setSpecification("商品规格");
    }

    @Test
    public void testInsert() throws Exception {
        this.goodsDao.insert(goods);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testGetList() throws Exception {

    }

    @Test
    public void testGetCount() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }
}
