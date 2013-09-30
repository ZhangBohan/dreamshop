package me.nengzhe.auth.service;

import me.nengzhe.auth.model.User;
import nengzhe.AbstractSpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: bohan
 * Date: 9/30/13
 * Time: 5:14 PM
 */
public class ActionServiceTest extends AbstractSpringTests {
    @Autowired
    private ActionService actionService;

    @Test
    public void testAdd() throws Exception {
        User user = new User();
        user.setId(1);
        this.actionService.add("测试行为", "这是一个测试行为", 0, user);
    }
}
