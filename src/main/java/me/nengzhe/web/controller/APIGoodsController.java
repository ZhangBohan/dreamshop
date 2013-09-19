package me.nengzhe.web.controller;

import me.nengzhe.base.exception.NotLoginException;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import me.nengzhe.base.utils.AuthUtils;
import me.nengzhe.base.utils.JsonResult;
import me.nengzhe.base.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public JsonResult<Map<String, Object>> getList(@RequestParam Integer offset, @RequestParam Integer size) throws NotLoginException {
        Map<String, Object> map = new HashMap<String, Object>();

        Pager pager = new Pager();
        pager.setOffset(offset);
        pager.setSize(size);

        List<Goods> list = this.goodsService.getGoodsList(new GoodsSearch(), pager, AuthUtils.getUser());

        map.put("list", list);
        map.put("pager", pager);
        return new JsonResult<Map<String, Object>>(map);
    }
}
