package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.Company;
import me.nengzhe.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: bohan
 * Date: 8/19/13
 * Time: 4:14 PM
 */
@Repository
public class CompanyDao extends JdbcDaoSupport implements BaseDao<Company> {

    @Autowired
    public CompanyDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public void insert(Company entity) {
        String sql = "INSERT INTO company (name, deleted, modified_at, create_at) VALUES (?,?,?,?)";
        this.getJdbcTemplate().update(sql, entity.getName(), entity.getDeleted(), entity.getModifiedAt(),
                entity.getCreateAt());
    }

    @Override
    public void update(Company entity) {
        String sql = "UPDATE company SET name=?, deleted=?, modified_at=?, create_at=? WHERE id=?";
        this.getJdbcTemplate().update(sql, entity.getName(), entity.getDeleted(), entity.getModifiedAt(),
                entity.getCreateAt(), entity.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM goods WHERE id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public Company get(Integer id) {
        String sql = "SELECT * FROM goods WHERE id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new CompanyMapper());
        } catch (DataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    class CompanyMapper implements RowMapper<Company> {

        @Override
        public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
            Company company = new Company();
            company.setId(rs.getInt("id"));
            company.setName(rs.getString("name"));
            company.setDeleted(rs.getBoolean("deleted"));
            company.setModifiedAt(rs.getDate("modified_at"));
            company.setCreateAt(rs.getDate("create_at"));

            return company;
        }
    }
}
