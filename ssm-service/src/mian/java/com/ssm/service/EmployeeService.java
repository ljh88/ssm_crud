package com.ssm.service;

import com.ssm.dao.EmployeeDao;
import com.ssm.pojo.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<EmployeeEntity> queryAllEmployee(EmployeeEntity employeeEntity){
        List<EmployeeEntity> resList = employeeDao.selectBy(employeeEntity);
        return resList;
    }

    public EmployeeEntity queryEmployee(Integer id){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity = employeeDao.selectID(id);
        return employeeEntity;

    }

    public void addEmployee(EmployeeEntity employeeEntity){
        int res = employeeDao.insert(employeeEntity);
    }

    public void updateEmployee(EmployeeEntity employeeEntity){
        int res = employeeDao.update(employeeEntity);
    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeDao.delete(id);
    }

}
