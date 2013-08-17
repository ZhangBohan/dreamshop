package me.nengzhe.goods.dao.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * User: Bohan
 * Date: 13-8-17
 * Time: 下午2:58
 */
public abstract class AbstractSpringJDBCDao {
    @Autowired
    private DataSource dataSource;
    protected JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
}
