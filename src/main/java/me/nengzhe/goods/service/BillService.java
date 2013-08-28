package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.dao.BillDao;
import me.nengzhe.goods.dao.BillDetailDao;
import me.nengzhe.goods.model.Bill;
import me.nengzhe.goods.model.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void add(List<BillDetail> billDetails, User user) throws NotImplException {
        Bill bill = new Bill();
        bill.init();
        bill.setUserId(user.getId());
        this.billDao.insert(bill);

        for(BillDetail billDetail : billDetails) {
            billDetail.setOrderId(bill.getId());
            this.billDetailDao.insert(billDetail);
        }
    }
}
