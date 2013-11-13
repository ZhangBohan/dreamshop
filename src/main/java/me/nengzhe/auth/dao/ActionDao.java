package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.Action;
import me.nengzhe.base.dao.BaseDao;
import me.nengzhe.base.exception.NotImplException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * User: bohan
 * Date: 9/30/13
 * Time: 5:02 PM
 */
@Repository
public class ActionDao extends JdbcDaoSupport implements BaseDao<Action> {

    @Autowired
    public ActionDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public Integer insert(Action entity) throws NotImplException {
        String sql = "INSERT INTO user_action(user_id,name,description,success_count,created_at) VALUES(?,?,?,?,?)";
        return super.getJdbcTemplate().update(sql, entity.getUserId(), entity.getName(), entity.getDescription(),
                entity.getSuccessCount(), entity.getCreatedAt());
    }

    @Override
    public Integer update(Action entity) throws NotImplException {
        throw new NotImplException();
    }

    @Override
    public Integer delete(Integer id) throws NotImplException {
        throw new NotImplException();
    }

    @Override
    public Action get(Integer id) throws NotImplException {
        throw new NotImplException();
    }
}
