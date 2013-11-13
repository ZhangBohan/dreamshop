package me.nengzhe.goods.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:26 PM
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillDetail {
    @JsonIgnore
    private Integer id;
    private Integer billId;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal cost;

    public BillDetail() {
    }

    public BillDetail(String name, Integer count, BigDecimal price, BigDecimal cost) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
