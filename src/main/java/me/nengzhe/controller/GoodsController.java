package me.nengzhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Bohan
 * Date: 13-8-18
 * Time: 下午2:57
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "goods/add.ftl";
    }
}
