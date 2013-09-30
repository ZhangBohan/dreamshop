package me.nengzhe.auth.model;

import java.util.Date;

/**
 * User: bohan
 * Date: 9/30/13
 * Time: 5:00 PM
 */
public class Action {
    private Integer id;
    private Integer userId;
    private String name;
    private String description;
    private Integer successCount;
    private Date createdAt;

    public Action() {
    }

    public Action(Integer userId, String name, String description, Integer successCount) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.successCount = successCount;
        this.createdAt = new Date();
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", successCount=" + successCount +
                ", createdAt=" + createdAt +
                '}';
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
