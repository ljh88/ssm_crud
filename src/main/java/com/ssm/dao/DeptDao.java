package com.ssm.dao;

import com.ssm.entity.DeptEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DeptDao{

    int insert(DeptEntity deptEntity);

    int updateById(DeptEntity deptEntity);

    List<DeptEntity> selectById(DeptEntity deptEntity);

}