package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.Authority;
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
import java.util.List;

/**
 * User: bohan
 * Date: 8/22/13
 * Time: 2:01 AM
 */
@Repository
public class AuthorityDao extends JdbcDaoSupport implements BaseDao<Authority> {

    @Autowired
    public AuthorityDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public void insert(Authority entity) {
        String sql = "INSERT INTO authority (name, description, modified_at, create_at) VALUES (?,?,?,?)";
        this.getJdbcTemplate().update(sql, entity.getName(), entity.getDescription(), entity.getModifiedAt(),
                entity.getCreateAt());
    }

    @Override
    public void update(Authority entity) {
        String sql = "UPDATE company SET name=?, deleted=?, modified_at=?, create_at=? WHERE id=?";
        this.getJdbcTemplate().update(sql, entity.getName(), entity.getDescription(), entity.getModifiedAt(),
                entity.getCreateAt(), entity.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM authority WHERE id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public Authority get(Integer id) {
        String sql = "SELECT * FROM authority WHERE id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new AuthorityMapper());
        } catch (EmptyResultDataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    public List<Authority> getListByUserId(Integer userId) {
        String sql = "SELECT auth.id, name, description, modified_at, create_at FROM authority auth, user_authority ua " +
                "WHERE auth.id = ua.user_id AND ua.user_id=?;";
        return super.getJdbcTemplate().query(sql, new Object[]{userId}, new AuthorityMapper());
    }

    class AuthorityMapper implements RowMapper<Authority> {

        @Override
        public Authority mapRow(ResultSet rs, int rowNum) throws SQLException {
            Authority authority = new Authority();
            authority.setId(rs.getInt("id"));
            authority.setName(rs.getString("name"));
            authority.setDescription(rs.getString("description"));
            authority.setModifiedAt(rs.getDate("modified_at"));
            authority.setCreateAt(rs.getDate("create_at"));

            return authority;
        }
    }
}
