package com.ssm.dao;

import com.ssm.pojo.EmployeeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author lijinghua
 * @Description:
 * @date
 */
public class EmployeeDaoTest extends BaseTest{

    @Autowired
    private EmployeeDao employeeDao;

    private EmployeeEntity employeeEntity = new EmployeeEntity();

    @Test
    public void insert() {
        for(int i = 1011; i <= 1020; i++){
            employeeEntity.setdId(1);
            employeeEntity.setEmpName("陈奕迅");
            employeeEntity.setEmail("chenyixun@163.com");
            employeeEntity.setGender("1");
            int result = employeeDao.insert(employeeEntity);
            System.out.println(result);
        }

    }

    @Test
    public void updateById() {
        employeeEntity.setdId(1);
        employeeEntity.setEmpName("刘若英");
        employeeEntity.setEmail("liuruoying@163.com");
        employeeEntity.setEmpId(1);
        employeeEntity.setGender("0");
        int result = employeeDao.update(employeeEntity);
        System.out.println(result);

    }

}