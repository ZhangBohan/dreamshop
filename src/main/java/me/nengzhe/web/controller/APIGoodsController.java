package me.nengzhe.web.controller;

import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import me.nengzhe.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: bohan
 * Date: 8/31/13
 * Time: 10:31 PM
 */
@Controller
@RequestMapping("/api/goods")
public class APIGoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/list")
    @ResponseBody
    public List<Goods> getList(@RequestParam Integer offset, @RequestParam Integer size) throws NotImplException {
        List<Goods> list = null;
        Pager pager = new Pager();

        list = this.goodsService.getGoodsList(new GoodsSearch(), pager);

        return list;
    }
}
