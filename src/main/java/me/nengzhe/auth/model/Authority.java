package me.nengzhe.auth.model;

import me.nengzhe.auth.dto.Role;
import me.nengzhe.base.model.BaseModel;
import org.springframework.security.core.GrantedAuthority;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 1:47 AM
 */
public class Authority extends BaseModel implements GrantedAuthority {
    private String name;
    private String description;

    public Authority() {
    }

    public Authority(Role role) {
        this.name = role.getRole();
        this.description = role.getDescription();
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
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

    @Override
    public String getAuthority() {
        return this.name;
    }
}
