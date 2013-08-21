package me.nengzhe.auth.service;

import me.nengzhe.auth.dao.AuthorityDao;
import me.nengzhe.auth.dao.UserDao;
import me.nengzhe.auth.dto.UserWithDetails;
import me.nengzhe.auth.model.Authority;
import me.nengzhe.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 1:25 AM
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthorityDao authorityDao;

    @Override
    public UserWithDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userDao.get(username);
        if(user == null) {
            throw new UsernameNotFoundException("该用户名不存在！");
        }

        UserWithDetails userWithDetails = new UserWithDetails();
        userWithDetails.setUser(user);
        // add Authority
        List<Authority> authorities = this.authorityDao.getListByUserId(user.getId());
        userWithDetails.setAuthorities(authorities);
        return userWithDetails;
    }
}
