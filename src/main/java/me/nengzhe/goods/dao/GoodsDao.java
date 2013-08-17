package me.nengzhe.goods.dao;

import me.nengzhe.goods.dao.base.PaginationDao;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.utils.Pager;
import me.nengzhe.utils.SearchAble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:55
 */
@Repository
public class GoodsDao extends JdbcDaoSupport implements PaginationDao<Goods> {
    @Autowired
    public GoodsDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public Goods get(String barCode) {
        String sql = "SELECT * FROM goods WHERE bar_code=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{barCode}, new GoodsMapper());
        } catch (DataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    @Override
    public void insert(Goods entity) {
        String sql = "INSERT INTO goods(bar_code, price, cost, specification, unit, status, " +
                "modified_at, create_at) VALUE (?,?,?,?,?,?,?,?);";
        super.getJdbcTemplate().update(sql, entity.getBarCode(), entity.getPrice(), entity.getCost(),
                entity.getSpecification(), entity.getUnit(), entity.getStatus(),
                entity.getModifiedAt(), entity.getCreateAt());
    }

    @Override
    public void update(Goods entity) {
        String sql = "UPDATE goods SET bar_code=?, price=?, cost=?, specification=?, unit=?, status=?, modified_at=?, create_at=? WHERE id=?;";

        super.getJdbcTemplate().update(sql, entity.getBarCode(), entity.getPrice(), entity.getCost(),
                entity.getSpecification(), entity.getUnit(), entity.getStatus(),
                entity.getModifiedAt(), entity.getCreateAt(), entity.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM goods WHERE id=?";
        super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public Goods get(Integer id) {
        String sql = "SELECT * FROM goods WHERE id=?";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new GoodsMapper());
        } catch (DataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    @Override
    public List<Goods> getList(Pager pager) {
        String sql = "SELECT * FROM goods";
        return super.getJdbcTemplate().query(sql,
                new GoodsMapper());
    }

    @Override
    public Integer getCount() {
        String sql = "SELECT COUNT(id) FROM goods";
        return super.getJdbcTemplate().queryForInt(sql);
    }

    @Override
    public List<Goods> getList(SearchAble search) {
        String sql = "SELECT * FROM goods";
        return super.getJdbcTemplate().query(sql,
                new GoodsMapper());
    }

    @Override
    public List<Goods> getList(SearchAble search, Pager pager) {
        String sql = "SELECT * FROM goods LIMIT ?,?";
        return super.getJdbcTemplate().query(sql,
                new Object[]{pager.getOffset(), pager.getSize()},
                new GoodsMapper());
    }

    @Override
    public Integer getCount(SearchAble search) {
        String sql = "SELECT COUNT(id) FROM goods";
        return super.getJdbcTemplate().queryForInt(sql);
    }

    class GoodsMapper implements RowMapper<Goods> {
        @Override
        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
            Goods goods = new Goods();
            goods.setBarCode(rs.getString("bar_code"));
            goods.setCost(rs.getBigDecimal("cost"));
            goods.setPrice(rs.getBigDecimal("price"));
            goods.setId(rs.getInt("id"));
            goods.setSpecification(rs.getString("specification"));
            goods.setStatus(rs.getBoolean("status"));
            goods.setUnit(rs.getString("unit"));
            goods.setModifiedAt(rs.getDate("modified_at"));
            goods.setCreateAt(rs.getDate("create_at"));
            return goods;
        }
    }
}
