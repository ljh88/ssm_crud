package com.ssm.facade;

import com.ssm.api.EmployeeFacade;

import com.ssm.common.PageInfoResponse;
import com.ssm.pojo.DeptEntity;
import com.ssm.pojo.EmployeeEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatis/mybatis-config.xml", "classpath:spring/applicationContext-dao.xml " })
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeFacade employeeFacade;
    @Test
    public void queryDepartment() {
        PageInfoResponse<DeptEntity> result =  employeeFacade.queryDepartment(new DeptEntity());
        System.out.println(result);
    }

    @Test
    public void queryEmployee() {
        PageInfoResponse<EmployeeEntity> employeeDtoPageInfoResponse = employeeFacade.queryEmployee(new EmployeeEntity());
        System.out.println(employeeDtoPageInfoResponse);
    }

    @Test
    public void updateEmployee() {
    }

    @Test
    public void deleteEmployee() {
    }

    @Test
    public void addEmployee() {
    }
}