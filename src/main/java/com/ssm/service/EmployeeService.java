package com.ssm.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.dao.DeptDao;
import com.ssm.dao.EmployeeDao;
import com.ssm.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<EmployeeEntity> queryAllEmployee(){
        List<EmployeeEntity> resList = employeeDao.selectById(null);
        return resList;
    }

    public EmployeeEntity queryEmployee(Integer id){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity = employeeDao.selectByPrimaryKey(id);
        return employeeEntity;

    }

    public void addEmployee(EmployeeEntity employeeEntity){
        int res = employeeDao.insert(employeeEntity);
    }

    public void updateEmployee(EmployeeEntity employeeEntity){
        int res = employeeDao.updateById(employeeEntity);
    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeDao.deleteByPrimaryKey(id);
    }

}
