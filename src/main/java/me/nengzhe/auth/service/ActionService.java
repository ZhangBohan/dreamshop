package me.nengzhe.auth.service;

import me.nengzhe.auth.dao.ActionDao;
import me.nengzhe.auth.model.Action;
import me.nengzhe.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: bohan
 * Date: 9/30/13
 * Time: 5:10 PM
 */
@Service
public class ActionService {
    @Autowired
    private ActionDao actionDao;

    public void add(String name, String description, Integer successCount, User user) {
        Action action = new Action(user.getId(), name, description, successCount);
        this.actionDao.insert(action);
    }

    public void add(String name, String description, User user) {
        this.add(name, description, 0, user);
    }
}
