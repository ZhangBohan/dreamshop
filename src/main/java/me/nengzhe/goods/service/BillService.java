package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.goods.dao.BillDao;
import me.nengzhe.goods.dao.BillDetailDao;
import me.nengzhe.goods.model.Bill;
import me.nengzhe.goods.model.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:47 PM
 */
@Service
public class BillService {
    @Autowired
    private BillDao billDao;
    @Autowired
    private BillDetailDao billDetailDao;

    public void add(Bill bill, User user){
        bill.init();
        bill.setUserId(user.getId());
        this.billDao.insert(bill);

        for(BillDetail billDetail : bill.getDetails()) {
            billDetail.setBillId(bill.getId());
            if(billDetail.getCost() == null){
                billDetail.setCost(new BigDecimal(-1));
            }
            this.billDetailDao.insert(billDetail);
        }
    }
}
