package me.nengzhe.goods.dao;

import me.nengzhe.base.dao.BaseDao;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.model.Bill;
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
 * Date: 8/28/13
 * Time: 10:38 PM
 */
@Repository
public class BillDao extends JdbcDaoSupport implements BaseDao<Bill>{

    @Autowired
    public BillDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public void insert(Bill entity) throws NotImplException {
        final String sql = "INSERT INTO bill(user_id, modified_at, create_at) VALUES(?,?,?)";

        final Bill bill = entity;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[]{"id"});
                        int index = 0;
                        ps.setInt(++ index, bill.getUserId());
                        ps.setDate(++index, new Date(bill.getModifiedAt().getTime()));
                        ps.setDate(++ index, new Date(bill.getCreateAt().getTime()));
                        return ps;
                    }
                },
                keyHolder);
        entity.setId(keyHolder.getKey().intValue());
    }

    @Override
    public void update(Bill entity) throws NotImplException {
        String sql = "UPDATE bill SET user_id=?, modified_at=?, create_at=? WHERE id=?";
        super.getJdbcTemplate().update(sql, entity.getUserId(), entity.getModifiedAt(),
                entity.getCreateAt(), entity.getId());
    }

    @Override
    public void delete(Integer id) throws NotImplException {
        String sql = "DELETE FROM bill WHERE id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public Bill get(Integer id) throws NotImplException {
        String sql = "SELECT * FROM bill WHERE id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new OrderMapper());
        } catch (EmptyResultDataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    class OrderMapper implements RowMapper<Bill>{
        @Override
        public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setUserId(rs.getInt("user_id"));
            bill.setModifiedAt(rs.getDate("modified_at"));
            bill.setCreateAt(rs.getDate("create_at"));
            return bill;
        }
    }
}