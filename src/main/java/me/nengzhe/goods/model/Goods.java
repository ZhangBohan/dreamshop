package me.nengzhe.goods.model;

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
    private String price;   // 价格
    private String cost;    // 成本
    private String specification;   // 规格
    private String unit;    // 单位

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
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
}
