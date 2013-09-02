package me.nengzhe.auth.service;

import me.nengzhe.utils.Md5PasswordEncoder;
import nengzhe.AbstractSpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: bohan
 * Date: 9/1/13
 * Time: 9:28 PM
 */
public class UserServiceTest extends AbstractSpringTests {
    @Autowired
    private UserService userService;

    @Test
    public void testLoadUserByUsername() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
        String username = "testUser";
        String password = "123456";

        try {
            this.userService.add(username, new Md5PasswordEncoder().encode(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
