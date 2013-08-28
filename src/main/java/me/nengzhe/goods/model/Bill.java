package me.nengzhe.goods.model;

import me.nengzhe.base.model.BaseModel;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:28 PM
 */
public class Bill extends BaseModel {
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
