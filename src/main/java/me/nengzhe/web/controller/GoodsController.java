package me.nengzhe.web.controller;

import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import me.nengzhe.utils.AuthUtils;
import me.nengzhe.utils.Pager;
import me.nengzhe.utils.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-18
 * Time: 下午2:57
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    public String listGet(Model model) throws NotImplException {
        List<Goods> list = this.goodsService.getGoodsList(new GoodsSearch(), new Pager());
        model.addAttribute("list", list);
        return "goods/list.ftl";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(Model model) {
        Goods goods = new Goods();
        model.addAttribute("goods", goods);

        return "goods/add.ftl";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@Valid Goods goods, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "goods/add.ftl";
        }

        Message message = new Message();

        this.goodsService.add(goods, AuthUtils.getUser());

        message.success("增加成功！");

        message.addToRedirectAttributes(redirectAttributes);
        return "redirect:/goods/add";
    }
}
