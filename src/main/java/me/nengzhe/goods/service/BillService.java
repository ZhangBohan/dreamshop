package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.goods.dao.BillDao;
import me.nengzhe.goods.dao.BillDetailDao;
import me.nengzhe.goods.dto.BillSearch;
import me.nengzhe.goods.model.Bill;
import me.nengzhe.goods.model.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
        bill.setCompanyId(user.getCompanyId());
        this.billDao.insert(bill);

        for(BillDetail billDetail : bill.getDetails()) {
            billDetail.setBillId(bill.getId());
            if(billDetail.getCost() == null){
                billDetail.setCost(new BigDecimal(-1));
            }
            this.billDetailDao.insert(billDetail);
        }
    }

    public List<Bill> getBills(BillSearch search) {
        return this.billDao.getList(search);
    }
}
