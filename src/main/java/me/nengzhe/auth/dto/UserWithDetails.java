package me.nengzhe.auth.dto;

import me.nengzhe.auth.model.Authority;
import me.nengzhe.auth.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 1:22 AM
 */
public class UserWithDetails implements UserDetails{
    private User user;
    private List<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !user.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !user.isCredentialsExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
