package com.ssm.dao;


import com.ssm.pojo.DeptEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author lijinghua
 * @Description:
 * @date
 */
public class DeptDaoTest extends BaseTest{

    @Autowired
    private  DeptDao deptDao;


    public static void main(String args[]){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        Object o = context.getBean("deptDao");
        System.out.println(o);
    }

    @Test
    public void insert() {
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptId(12111);
        deptEntity.setDeptName("中台研发部");
        int result = deptDao.insert(deptEntity);
        System.out.println(result);
    }

    @Test
    public void updateById() {
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptName("海关业务部");
        deptEntity.setDeptId(11);
        int result = deptDao.update(deptEntity);
        System.out.println(result);
    }

    @Test
    public void selectById() {
        DeptEntity deptEntity = new DeptEntity();
        List<DeptEntity> result = deptDao.selectBy(deptEntity);
        System.out.println(result);
    }
}