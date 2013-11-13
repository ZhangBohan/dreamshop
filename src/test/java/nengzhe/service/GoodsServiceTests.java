package nengzhe.service;

import me.nengzhe.goods.service.GoodsService;
import nengzhe.AbstractSpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午5:23
 */
public class GoodsServiceTests extends AbstractSpringTests {
    @Autowired
    private GoodsService goodsService;
}
