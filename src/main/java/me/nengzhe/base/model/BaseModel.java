package me.nengzhe.base.model;

import java.util.Date;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 1:51 AM
 */
public abstract class BaseModel {
    protected Integer id;
    protected Date modifiedAt; // 修改时间
    protected Date createAt; // 创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
