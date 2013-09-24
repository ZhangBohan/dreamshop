package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: bohan
 * Date: 8/21/13
 * Time: 11:57 PM
 */
@Repository
public class UserDao extends JdbcDaoSupport implements BaseDao<User>{

    @Autowired
    public UserDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO dream_shop.user (username, password, company_id, account_expired, account_locked, " +
                "credentials_expired, enabled, modified_at, create_at) VALUES (?,?,?,?,?,?,?,?,?);";
        super.getJdbcTemplate().update(sql, user.getUsername(), user.getPassword(), user.getCompanyId(),
                user.isAccountExpired(), user.isAccountLocked(), user.isCredentialsExpired(), user.isEnabled(),
                user.getModifiedAt(), user.getCreateAt());
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET username=?, password=?, company_id=?, account_expired=?, account_locked=?, " +
                "credentials_expired=?, enabled=?, modified_at=?, create_at=? WHERE id=?;";
        super.getJdbcTemplate().update(sql, user.getUsername(), user.getPassword(), user.getCompanyId(),
                user.isAccountExpired(), user.isAccountLocked(), user.isCredentialsExpired(), user.isEnabled(),
                user.getModifiedAt(), user.getCreateAt(), user.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM user WHERE id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public User get(Integer id) {
        String sql = "SELECT * FROM user WHERE id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new UserRowMapper());
        } catch (DataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    public User get(String username) {
        String sql = "SELECT * FROM user WHERE username=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{username}, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setCompanyId(rs.getInt("company_id"));

            user.setAccountExpired(rs.getBoolean("account_expired"));
            user.setAccountLocked(rs.getBoolean("account_locked"));
            user.setCredentialsExpired(rs.getBoolean("credentials_expired"));
            user.setEnabled(rs.getBoolean("enabled"));

            user.setModifiedAt(rs.getTimestamp("modified_at"));
            user.setCreateAt(rs.getTimestamp("create_at"));

            return user;
        }
    }
}
