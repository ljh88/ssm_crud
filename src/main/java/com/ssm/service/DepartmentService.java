package com.ssm.service;

import com.ssm.dao.DeptDao;
import com.ssm.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DeptDao deptDao;

    public List<DeptEntity> queryDept(DeptEntity deptEntity){
        List<DeptEntity> deptEntityList = deptDao.selectById(deptEntity);
        return deptEntityList;
    }
}
