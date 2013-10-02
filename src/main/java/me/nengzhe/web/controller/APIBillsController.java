package me.nengzhe.web.controller;

import me.nengzhe.base.exception.NotLoginException;
import me.nengzhe.base.utils.AuthUtils;
import me.nengzhe.base.utils.JsonResult;
import me.nengzhe.goods.model.Bill;
import me.nengzhe.goods.service.BillService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * User: bohan
 * Date: 9/16/13
 * Time: 11:09 PM
 */
@Controller
@RequestMapping("/api/bills")
public class APIBillsController {
    @Autowired
    private BillService billService;

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult<Object> bill(@RequestParam String result, ObjectMapper mapper) throws NotLoginException, IOException {

        Bill bill = mapper.readValue(result, Bill.class);
        this.billService.add(bill, AuthUtils.getUser());
        return new JsonResult<Object>();
    }
}
