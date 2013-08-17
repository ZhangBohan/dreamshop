package me.nengzhe.goods.dao;

import me.nengzhe.goods.dao.base.AbstractSpringJDBCDao;
import me.nengzhe.goods.dao.base.BaseDao;
import me.nengzhe.goods.model.Goods;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:55
 */
@Repository
public class GoodsDao extends AbstractSpringJDBCDao implements BaseDao<Goods> {
    @Override
    public void insert(Goods entity) {
        String sql = "INSERT INTO goods(bar_code, price, cost, specification, unit, status, " +
                "modified_at, create_at) VALUE (?,?,?,?,?,?,?,?);";
        super.jdbcTemplate.update(sql, entity.getBarCode(), entity.getPrice(), entity.getCost(),
                entity.getSpecification(), entity.getUnit(), entity.getStatus(),
                entity.getModifiedAt(), entity.getCreateAt());
    }

    @Override
    public void update(Goods entity) {
        String sql = "UPDATE goods SET bar_code=?, price=?, cost=?, specification=?, unit=?, status=?, modified_at=?, create_at=? WHERE id=?;";

        super.jdbcTemplate.update(sql, entity.getBarCode(), entity.getPrice(), entity.getCost(),
                entity.getSpecification(), entity.getUnit(), entity.getStatus(),
                entity.getModifiedAt(), entity.getCreateAt(), entity.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM goods WHERE id=?";
        super.jdbcTemplate.update(sql, id);
    }

    @Override
    public Goods get(Integer id) {
        String sql = "SELECT * FROM goods WHERE id=?";
        return super.jdbcTemplate.queryForObject(sql, new Object[]{id}, new GoodsMapper());
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
