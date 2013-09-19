package me.nengzhe.web.controller;

import me.nengzhe.auth.dto.SignUp;
import me.nengzhe.auth.service.UserService;
import me.nengzhe.base.utils.Md5PasswordEncoder;
import me.nengzhe.base.utils.message.Message;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

/**
 * User: bohan
 * Date: 9/1/13
 * Time: 7:34 PM
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam(defaultValue = "") String error, Model model) {

        if(StringUtils.isNotBlank(error)) {
            Message message = new Message();
            if("uop".equals(error)) {
                message.error("用户名或密码错误！");
            }
            message.addToModel(model);
        }

        return "auth/login";
    }

    @RequestMapping("/signUp")
    public String signUpGet(Model model) {
        model.addAttribute("signUp", new SignUp());
        return "auth/sign_up";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUpPost(@Valid SignUp signUp, BindingResult result,
                             RedirectAttributes redirectAttributes) {

        if(result.hasErrors()) {
            return "auth/sign_up";
        } else {
            try {
                this.userService.loadUserByUsername(signUp.getUsername());
                result.addError(new ObjectError("signUp", "该用户名被占用，请重新输入用户名！"));
                return "auth/sign_up";
            } catch (UsernameNotFoundException e) {
                // 没找到很正常
            }
        }
        Message message = new Message();

        this.userService.add(signUp.getUsername(), new Md5PasswordEncoder().encode(signUp.getPassword()));
        message.success("恭喜，您的账号已注册成功！登录后即可以使用该系统。");
        message.addToRedirectAttributes(redirectAttributes);
        return "redirect:/auth/login";
    }
}
