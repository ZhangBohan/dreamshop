package me.nengzhe.auth.model;

import java.util.Date;

/**
 * User: bohan
 * Date: 8/21/13
 * Time: 11:16 PM
 */
public class User {
    private Integer id;
    private String username;    // 用户
    private String password;    // 密码
    private Integer companyId;  // 公司ID

    private boolean accountExpired; // 账号过期
    private boolean accountLocked; // 账号锁定
    private boolean credentialsExpired; // 密码过期
    private boolean enabled;    // 可用

    private Date modifiedAt; // 修改时间
    private Date createAt; // 创建时间

    public User() {
        init();
    }

    public void init() {
        accountExpired = false;
        accountLocked = false;
        credentialsExpired = false;
        enabled = true;

        modifiedAt = new Date();
        createAt = new Date();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
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
