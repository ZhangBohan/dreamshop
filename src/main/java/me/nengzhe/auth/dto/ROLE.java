package me.nengzhe.auth.dto;

/**
 * User: bohan
 * Date: 9/1/13
 * Time: 8:58 PM
 */
public enum Role {
    RoleUser("ROLE_USER", "初始用户权限。");

    private String role;
    private String description;

    private Role(String role, String description) {
        this.role = role;
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
