package me.nengzhe.goods.dao;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.dao.PaginationDao;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.base.utils.Pager;
import me.nengzhe.goods.dto.BillSearch;
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
import java.util.List;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:38 PM
 */
@Repository
public class BillDao extends JdbcDaoSupport implements PaginationDao<Bill, BillSearch> {

    @Autowired
    public BillDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public Integer insert(Bill entity) throws NotImplException {
        final String sql = "INSERT INTO bill(company_id, total, modified_at, create_at) VALUES(?,?,?,?)";

        final Bill bill = entity;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        super.getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[]{"id"});
                        int index = 0;
                        ps.setInt(++ index, bill.getCompanyId());
                        ps.setBigDecimal(++ index, bill.getTotal());
                        ps.setDate(++index, new Date(bill.getModifiedAt().getTime()));
                        ps.setDate(++ index, new Date(bill.getCreateAt().getTime()));
                        return ps;
                    }
                },
                keyHolder);
        entity.setId(keyHolder.getKey().intValue());
        return 1;   // One column success
    }

    @Override
    public Integer update(Bill entity) throws NotImplException {
        String sql = "UPDATE bill SET company_id=?, total, modified_at=?, create_at=? WHERE id=?";
        return super.getJdbcTemplate().update(sql, entity.getCompanyId(), entity.getTotal(), entity.getModifiedAt(),
                entity.getCreateAt(), entity.getId());
    }

    @Override
    public Integer delete(Integer id) throws NotImplException {
        String sql = "DELETE FROM bill WHERE id=?";
        return super.getJdbcTemplate().update(sql, id);
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

    @Override
    public List<Bill> getList(BillSearch search, Pager pager, User user) throws NotImplException {
        String sql = "SELECT * FROM bill WHERE company_id=? LIMIT ?,?";
        return super.getJdbcTemplate().query(sql, new Object[]{user.getCompanyId(),
                pager.getOffset(), pager.getSize()}, new OrderMapper());
    }

    @Override
    public int getCount(BillSearch search, User user) throws NotImplException {
        String sql = "SELECT COUNT(*) FROM bill WHERE company_id=?";
        return super.getJdbcTemplate().queryForInt(sql, new Object[]{user.getCompanyId()});
    }

    @Override
    public List<Bill> getList(BillSearch search) throws NotImplException {
        throw new NotImplException();
    }

    class OrderMapper implements RowMapper<Bill>{
        @Override
        public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setCompanyId(rs.getInt("company_id"));
            bill.setTotal(rs.getBigDecimal("total"));
            bill.setModifiedAt(rs.getTimestamp("modified_at"));
            bill.setCreateAt(rs.getTimestamp("create_at"));
            return bill;
        }
    }
}
