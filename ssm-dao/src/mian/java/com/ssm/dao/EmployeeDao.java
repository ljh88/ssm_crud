package com.ssm.dao;


import com.ssm.pojo.EmployeeEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeDao extends BaseDao<Integer, EmployeeEntity>{

}