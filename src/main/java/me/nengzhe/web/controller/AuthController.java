package me.nengzhe.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: bohan
 * Date: 9/1/13
 * Time: 7:34 PM
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @RequestMapping("/login")
    public String login() {
        return "auth/login";
    }
}
