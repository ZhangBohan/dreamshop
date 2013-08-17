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

    private Boolean delete; // 是否被删除
    private Date modifiedAt; // 修改时间
    private Date createAt; // 创建时间


}
