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
    private Integer companyId;
    private BigDecimal total;
    private List<BillDetail> details;

    @Override
    public String toString() {
        return "Bill{" +
                "companyId=" + companyId +
                ", total=" + total +
                ", details=" + details +
                '}';
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<BillDetail> getDetails() {
        return details;
    }

    public void setDetails(List<BillDetail> details) {
        this.details = details;
    }
}
