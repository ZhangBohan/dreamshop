package me.nengzhe.goods.dao;

import me.nengzhe.base.dao.BaseDao;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.model.BillDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: bohan
 * Date: 8/28/13
 * Time: 10:28 PM
 */
@Repository
public class BillDetailDao extends JdbcDaoSupport implements BaseDao<BillDetail> {

    @Autowired
    public BillDetailDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    @Override
    public void insert(BillDetail entity) throws NotImplException {
        String sql = "INSERT INTO bill_detail(order_id, name, count, price, cost) VALUES (?,?,?,?,?)";
        super.getJdbcTemplate().update(sql, entity.getOrderId(), entity.getName(), entity.getCount(),
                entity.getPrice(), entity.getCost());
    }

    @Override
    public void update(BillDetail entity) throws NotImplException {
        String sql = "UPDATE bill_detail SET order_id=?, name=?, count=?, price=?, cost=? WHERE id=?";
        super.getJdbcTemplate().update(sql, entity.getOrderId(), entity.getName(), entity.getCount(),
                entity.getPrice(), entity.getCost(), entity.getId());
    }

    @Override
    public void delete(Integer id) throws NotImplException {
        String sql = "DELETE FROM bill_detail WHERE id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public BillDetail get(Integer id) throws NotImplException {
        String sql = "SELECT * FROM bill_detail WHERE id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new OrderDetailMapper());
        } catch (EmptyResultDataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    public BillDetail getByOrderId(Integer orderId) throws NotImplException {
        String sql = "SELECT * FROM bill_detail WHERE order_id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{orderId}, new OrderDetailMapper());
        } catch (EmptyResultDataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    class OrderDetailMapper implements RowMapper<BillDetail> {
        @Override
        public BillDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            BillDetail billDetail = new BillDetail();
            billDetail.setId(rs.getInt("id"));
            billDetail.setOrderId(rs.getInt("order_id"));
            billDetail.setName(rs.getString("name"));
            billDetail.setCount(rs.getInt("count"));
            billDetail.setPrice(rs.getBigDecimal("price"));
            billDetail.setCost(rs.getBigDecimal("cost"));
            return billDetail;
        }
    }
}
