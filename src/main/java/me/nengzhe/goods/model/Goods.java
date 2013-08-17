package me.nengzhe.goods.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品实体
 *
 * User: Bohan
 * Date: 13-8-11
 * Time: 下午10:01
 */
public class Goods {
    private Integer id;
    private String barCode;  // 条码
    private BigDecimal price;   // 价格
    private BigDecimal cost;    // 成本
    private String specification;   // 规格
    private String unit;    // 单位

    private Boolean status; // 是否被删除
    private Date modifiedAt; // 修改时间
    private Date createAt; // 创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
