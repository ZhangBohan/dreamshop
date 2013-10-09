package me.nengzhe.base.model;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.utils.Pager;

/**
 * User: bohan
 * Date: 10/4/13
 * Time: 3:31 PM
 */
public abstract class BaseSearch {
    private User user;
    private Pager pager;

    @Override
    public String toString() {
        return "BaseSearch{" +
                "user=" + user +
                ", pager=" + pager +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }
}
