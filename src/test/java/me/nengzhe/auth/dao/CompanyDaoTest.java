package me.nengzhe.auth.dao;

import me.nengzhe.auth.model.Company;
import nengzhe.AbstractSpringTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: bohan
 * Date: 8/19/13
 * Time: 4:31 PM
 */
public class CompanyDaoTest extends AbstractSpringTests {

    @Autowired
    private CompanyDao companyDao;

    private Company company;

    @Test
    public void testInsert() throws Exception {
        Company company = new Company();
        company.setName("test company");
        this.companyDao.insert(company);
    }

    @Test
    public void testUpdate() throws Exception {
        Company company = new Company();
        company.setName("test company");
        company.setId(1);
        this.companyDao.update(company);
    }

    @Test
    public void testGet() throws Exception {
        Company company = new Company();
        company.setName("test company");
        this.testInsert();
        this.companyDao.get(company.getId());
    }

    @Test
    public void testDelete() throws Exception {
        Company company = new Company();
        company.setName("test company");
        this.testInsert();
        this.companyDao.delete(company.getId());
    }
}
