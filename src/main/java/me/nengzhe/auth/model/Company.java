package me.nengzhe.auth.model;

import me.nengzhe.base.model.BaseModel;

import java.util.Date;

/**
 * User: bohan
 * Date: 8/19/13
 * Time: 3:34 PM
 */
public class Company extends BaseModel {
    private String name;
    private String description;

    private Boolean deleted; // 是否被删除

    public Company() {
        this.deleted = false;
        this.modifiedAt = new Date();
        this.createAt = new Date();
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
