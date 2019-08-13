package com.ssm.dao;

import com.ssm.entity.DeptEntity;
import com.ssm.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDao{

    int insert(EmployeeEntity employeeEntity);

    int updateById(EmployeeEntity employeeEntity);

    List<EmployeeEntity> selectById(EmployeeEntity employeeEntity);

    EmployeeEntity selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer empId);

}