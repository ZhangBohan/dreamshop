package me.nengzhe.goods.service;

import me.nengzhe.auth.model.User;
import me.nengzhe.goods.model.BillDetail;
import nengzhe.AbstractSpringTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:57 PM
 */
public class BillServiceTest extends AbstractSpringTests {
    @Autowired
    private BillService billService;

    private User user;
    private List<BillDetail> billDetails;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(3);

        billDetails = new ArrayList<BillDetail>();
        billDetails.add(new BillDetail("name1", 1, new BigDecimal(10), new BigDecimal(8)));
        billDetails.add(new BillDetail("name2", 2, new BigDecimal(101), new BigDecimal(81)));
        billDetails.add(new BillDetail("name3", 3, new BigDecimal(102), new BigDecimal(82)));
        billDetails.add(new BillDetail("name4", 4, new BigDecimal(103), new BigDecimal(83)));
    }

    @Test
    public void testAdd() throws Exception {
        this.billService.add(billDetails, user);
    }
}
