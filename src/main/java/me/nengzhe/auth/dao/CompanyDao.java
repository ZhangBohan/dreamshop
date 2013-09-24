package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.Company;
import me.nengzhe.base.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;

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
        final String sql = "INSERT INTO company (name, description, deleted, modified_at, create_at) VALUES (?,?,?,?,?)";
        final Company company = entity;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[]{"id"});
                        int index = 0;
                        ps.setString(++ index, company.getName());
                        ps.setString(++ index, company.getDescription());
                        ps.setBoolean(++ index, company.getDeleted());
                        ps.setDate(++ index, new Date(company.getModifiedAt().getTime()));
                        ps.setDate(++ index, new Date(company.getCreateAt().getTime()));
                        return ps;
                    }
                },
                keyHolder);
        entity.setId(keyHolder.getKey().intValue());
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
        } catch (EmptyResultDataAccessException e) {
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
            company.setModifiedAt(rs.getTimestamp("modified_at"));
            company.setCreateAt(rs.getTimestamp("create_at"));

            return company;
        }
    }
}
