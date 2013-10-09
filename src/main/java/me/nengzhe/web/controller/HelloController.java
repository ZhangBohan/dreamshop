package me.nengzhe.web.controller;

import me.nengzhe.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {
    @Autowired
    private GoodsService goodsService;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome() {
		return "redirect:/sell";
	}
}