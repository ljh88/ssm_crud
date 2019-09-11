package com.ssm.api;


import com.ssm.common.MessageResponse;
import com.ssm.common.PageInfoResponse;
import com.ssm.pojo.DeptEntity;
import com.ssm.pojo.EmployeeEntity;


public interface EmployeeFacade {

    PageInfoResponse<DeptEntity> queryDepartment(DeptEntity deptEntity);

    PageInfoResponse<EmployeeEntity> queryEmployee(EmployeeEntity employeeEntity);

    MessageResponse updateEmployee(EmployeeEntity employeeEntity);

    MessageResponse deleteEmployee(Integer id);

    MessageResponse addEmployee(EmployeeEntity employeeEntity);
}
