package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.User;
import nengzhe.AbstractSpringTests;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import java.util.Date;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 12:16 AM
 */
public class UserDaoTest extends AbstractSpringTests {
    @Autowired
    private UserDao userDao;

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUsername("bohan");
        user.setPassword("123456");
        user.setCompanyId(1);
    }

    @Test
    public void testInsert() throws Exception {
        try {
            this.userDao.insert(user);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate() throws Exception {
        user.setId(1);
        user.setModifiedAt(new Date());
        this.userDao.update(user);
    }

    @Test
    public void testDelete() throws Exception {
        this.userDao.delete(1);
    }

    @Test
    public void testGet() throws Exception {
        this.user = this.userDao.get(1);
    }
}
