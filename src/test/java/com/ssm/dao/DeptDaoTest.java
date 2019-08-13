package com.ssm.dao;

import com.ssm.entity.DeptEntity;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:mybatis-config.xml" , "classpath:applicationContext.xml" })
public class DeptDaoTest {

    @Autowired
    private  DeptDao deptDao;

    private DeptEntity deptEntity = new DeptEntity();

    @Test
    public void insert() {
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptId(11);
        deptEntity.setDeptName("中台研发部");
        int result = deptDao.insert(deptEntity);
        System.out.println(result);
    }

    @Test
    public void updateById() {

        deptEntity.setDeptName("海关业务部");
        deptEntity.setDeptId(11);
        int result = deptDao.updateById(deptEntity);
        System.out.println(result);
    }

    @Test
    public void selectById() {

        List<DeptEntity> result = deptDao.selectById(deptEntity);
        System.out.println(result);
    }
}