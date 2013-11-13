package me.nengzhe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: bohan
 * Date: 8/31/13
 * Time: 9:32 PM
 */
@Controller
@RequestMapping("/sell")
public class BillController {
    @RequestMapping
    public String sell() {
        return "bill/index";
    }
}
