package me.nengzhe.web.controller;

import me.nengzhe.auth.service.ActionService;
import me.nengzhe.base.exception.LogicException;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.base.exception.NotLoginException;
import me.nengzhe.base.utils.AuthUtils;
import me.nengzhe.base.utils.Pager;
import me.nengzhe.base.utils.message.Message;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private ActionService actionService;

    @RequestMapping(method = RequestMethod.GET)
    public String listWithPagerGet(Model model, @RequestParam(defaultValue = "30") Integer pageSize,
                                   @RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "-1") Integer total) throws NotImplException, NotLoginException {
        Pager pager = new Pager(page, total, pageSize);

        List<Goods> list = this.goodsService.getGoodsList(new GoodsSearch(), pager, AuthUtils.getUser());
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        return "goods/list";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String listWithPagerPost(GoodsSearch search, Model model, @RequestParam(defaultValue = "2") Integer pageSize,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "-1") Integer total) throws NotImplException, NotLoginException {
        Pager pager = new Pager(page, total, pageSize);

        List<Goods> list = this.goodsService.getGoodsList(search, pager, AuthUtils.getUser());
        model.addAttribute("list", list);
        model.addAttribute("pager", pager);
        model.addAttribute("search", search);
        return "goods/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(Model model) {
        Goods goods = new Goods();
        model.addAttribute("goods", goods);

        return "goods/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@Valid Goods goods, BindingResult result,
                          RedirectAttributes redirectAttributes, Model model) throws NotLoginException {
        if (result.hasErrors()) {
            return "goods/add";
        }

        Message message = new Message();

        try {
            this.goodsService.add(goods, AuthUtils.getUser());
        } catch (LogicException e) {
            message.error(e.getMessage());
            message.addToModel(model);
            return "goods/add";
        }

        message.success("增加成功！");

        message.addToRedirectAttributes(redirectAttributes);
        this.actionService.add("增加商品", "增加成功！", AuthUtils.getUser());
        return "redirect:/goods/add";
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes)
            throws NotLoginException {
        Message message = new Message();

        this.goodsService.delete(id, AuthUtils.getUser());

        message.success("删除成功！");

        message.addToRedirectAttributes(redirectAttributes);
        this.actionService.add("删除商品", "ID:" + id, AuthUtils.getUser());
        return "redirect:/goods";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editGet(Model model, @PathVariable("id") int id) throws NotLoginException {
        Goods goods = this.goodsService.getGoods(id, AuthUtils.getUser());
        model.addAttribute("goods", goods);

        return "goods/edit";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String editPost(@Valid Goods goods, BindingResult result, Model model)
            throws NotLoginException {
        if (result.hasErrors()) {
            return "goods/edit";
        }

        Message message = new Message();

        goods = this.goodsService.update(goods, AuthUtils.getUser());

        message.success("修改成功！");

        message.addToModel(model);
        model.addAttribute("goods", goods);
        this.actionService.add("修改商品", "修改成功！", AuthUtils.getUser());
        return "goods/edit";
    }
}
