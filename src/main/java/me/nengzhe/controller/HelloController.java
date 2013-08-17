package me.nengzhe.controller;

import com.google.gson.Gson;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private GoodsService goodsService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "你好，世界!");
		return "hello.ftl";
	}

    @RequestMapping(value = "/get")
    @ResponseBody
    public String getGoods() {
        Goods goods = this.goodsService.getGoods(1);
        return new Gson().toJson(goods);
    }
}