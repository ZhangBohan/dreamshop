package me.nengzhe.goods.dao;

import me.nengzhe.auth.model.User;
import me.nengzhe.base.dao.PaginationDao;
import me.nengzhe.base.exception.NotImplException;
import me.nengzhe.goods.dto.GoodsSearch;
import me.nengzhe.goods.model.Goods;
import me.nengzhe.base.utils.Pager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:55
 */
@Repository
public class GoodsDao extends JdbcDaoSupport implements PaginationDao<Goods, GoodsSearch> {
    @Autowired
    public GoodsDao(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public Goods get(String barCode) {
        String sql = "SELECT * FROM goods WHERE bar_code=? AND deleted=false";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{barCode}, new GoodsMapper());
        } catch (EmptyResultDataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    @Override
    public Integer insert(Goods entity) {
        String sql = "INSERT INTO goods(bar_code, name, price, cost, specification, unit, company_id, deleted, " +
                "modified_at, create_at) VALUES (?,?,?,?,?,?,?,?,?,?);";
        return super.getJdbcTemplate().update(sql, entity.getBarCode(), entity.getName(), entity.getPrice(),
                entity.getCost(), entity.getSpecification(), entity.getUnit(), entity.getCompanyId(), entity.getDeleted(),
                entity.getModifiedAt(), entity.getCreateAt());
    }

    @Override
    public Integer update(Goods entity) {
        String sql = "UPDATE goods SET bar_code=?, name=?, price=?, cost=?, specification=?, " +
                "unit=?, company_id=?, deleted=?, modified_at=?, create_at=? WHERE id=?;";

        return super.getJdbcTemplate().update(sql, entity.getBarCode(), entity.getName(), entity.getPrice(), entity.getCost(),
                entity.getSpecification(), entity.getUnit(), entity.getCompanyId(), entity.getDeleted(),
                entity.getModifiedAt(), entity.getCreateAt(), entity.getId());
    }

    @Override
    public Integer delete(Integer id) {
        String sql = "DELETE FROM goods WHERE id=?";
        return super.getJdbcTemplate().update(sql, id);
    }

    @Override
    public Goods get(Integer id) {
        String sql = "SELECT * FROM goods WHERE id=? AND deleted=false";
        try {
            return super.getJdbcTemplate().queryForObject(sql, new Object[]{id}, new GoodsMapper());
        } catch (DataAccessException e) {
            // return null or many object will raise exception.
            return null;
        }
    }

    @Override
    public List<Goods> getList(GoodsSearch search) throws NotImplException {
        String sql = "SELECT * FROM goods WHERE deleted=false";
        return super.getJdbcTemplate().query(sql, new Object[]{}, new GoodsMapper());
    }

    @Override
    public int getCount(GoodsSearch search, User user) throws NotImplException {
        List<Object> paramList = new ArrayList<Object>();
        String sql = "SELECT COUNT(*) FROM goods WHERE deleted=false AND company_id=?";
        paramList.add(user.getCompanyId());
        if(StringUtils.isNotBlank(search.getText())) {
            sql += " AND name LIKE ? ";
            paramList.add("%" + search.getText() + "%");
        }
        return super.getJdbcTemplate().queryForInt(sql, paramList.toArray());
    }

    @Override
    public List<Goods> getList(GoodsSearch search, Pager pager, User user) throws NotImplException {
        List<Object> paramList = new ArrayList<Object>();
        String sql = "SELECT * FROM goods WHERE deleted=false AND company_id=? ";
        paramList.add(user.getCompanyId());
        if(StringUtils.isNotBlank(search.getText())) {
            sql += "AND name LIKE ? ";
            paramList.add("%" + search.getText() + "%");
        }
        sql += "LIMIT ?,?";
        paramList.add(pager.getOffset());
        paramList.add(pager.getSize());
        return super.getJdbcTemplate().query(sql, paramList.toArray(), new GoodsMapper());
    }

    class GoodsMapper implements RowMapper<Goods> {
        @Override
        public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
            Goods goods = new Goods();
            goods.setBarCode(rs.getString("bar_code"));
            goods.setName(rs.getString("name"));
            goods.setCost(rs.getBigDecimal("cost"));
            goods.setPrice(rs.getBigDecimal("price"));
            goods.setId(rs.getInt("id"));
            goods.setSpecification(rs.getString("specification"));
            goods.setDeleted(rs.getBoolean("deleted"));
            goods.setUnit(rs.getString("unit"));
            goods.setModifiedAt(rs.getTimestamp("modified_at"));
            goods.setCreateAt(rs.getTimestamp("create_at"));
            goods.setCompanyId(rs.getInt("company_id"));
            return goods;
        }
    }
}
