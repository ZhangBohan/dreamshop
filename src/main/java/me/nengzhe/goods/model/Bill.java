package me.nengzhe.goods.model;

import me.nengzhe.base.model.BaseModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:28 PM
 */
public class Bill extends BaseModel {
    private Integer userId;
    private BigDecimal total;
    private List<BillDetail> details;

    public List<BillDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BillDetail> details) {
        this.details = details;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
