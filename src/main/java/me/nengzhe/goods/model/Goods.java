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
    private String name;    // 名称
    private BigDecimal price;   // 价格
    private BigDecimal cost;    // 成本
    private String specification;   // 规格
    private String unit;    // 单位

    private Boolean deleted; // 是否被删除
    private Date modifiedAt; // 修改时间
    private Date createAt; // 创建时间

    public Goods() {
        init();
    }

    public void init() {
        this.deleted = false;
        this.modifiedAt = new Date();
        this.createAt = new Date();
        this.cost = new BigDecimal(0);
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", barCode='" + barCode + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cost=" + cost +
                ", specification='" + specification + '\'' +
                ", unit='" + unit + '\'' +
                ", deleted=" + deleted +
                ", modifiedAt=" + modifiedAt +
                ", createAt=" + createAt +
                '}';
    }

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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
