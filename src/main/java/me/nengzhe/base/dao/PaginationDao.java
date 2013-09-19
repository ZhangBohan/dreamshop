package me.nengzhe.base.dao;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.base.utils.Pager;

import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:45
 */
public interface PaginationDao<T, K> extends BaseDao<T> {
    List<T> getList(K search, Pager pager, User user) throws NotImplException;
    int getCount(K search, User user) throws NotImplException;

    List<T> getList(K search) throws NotImplException;
}
