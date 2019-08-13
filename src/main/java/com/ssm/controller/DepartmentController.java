package com.ssm.controller;

import com.ssm.entity.DeptEntity;
import com.ssm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/dept")
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("/queryDept")
    public List<DeptEntity> queryDet(){
        DeptEntity deptEntity = new DeptEntity();
        List<DeptEntity> deptEntityList = departmentService.queryDept(deptEntity);
        return deptEntityList;
    }
    @ResponseBody
    @RequestMapping("/queryDepart")
    public DeptEntity queryDepartment(Integer id){
        DeptEntity deptEntity = new DeptEntity();
        deptEntity.setDeptId(id);
        List<DeptEntity> deptEntityList = departmentService.queryDept(deptEntity);
        return deptEntityList.get(0);
    }
}
