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
import org.springframework.web.bind.annotation.PathVariable;
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
        return "goods/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(Model model) {
        Goods goods = new Goods();
        model.addAttribute("goods", goods);

        return "goods/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@Valid Goods goods, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "goods/add";
        }

        Message message = new Message();

        this.goodsService.add(goods, AuthUtils.getUser());

        message.success("增加成功！");

        message.addToRedirectAttributes(redirectAttributes);
        return "redirect:/goods";
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        Message message = new Message();

        this.goodsService.delete(id);

        message.success("删除成功！");

        message.addToRedirectAttributes(redirectAttributes);
        return "redirect:/goods";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editGet(Model model, @PathVariable("id") int id) {
        Goods goods = this.goodsService.getGoods(id);
        model.addAttribute("goods", goods);

        return "goods/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String editPost(@Valid Goods goods, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "goods/edit";
        }

        Message message = new Message();

        this.goodsService.update(goods, AuthUtils.getUser());

        message.success("修改成功！");

        message.addToRedirectAttributes(redirectAttributes);
        return "redirect:/goods";
    }
}
