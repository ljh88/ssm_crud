package com.ssm.facade;

import com.github.pagehelper.PageInfo;
import com.ssm.api.EmployeeFacade;
import com.ssm.common.MessageResponse;
import com.ssm.common.PageInfoResponse;
import com.ssm.enums.ErrorCode;
import com.ssm.pojo.DeptEntity;
import com.ssm.pojo.EmployeeEntity;
import com.ssm.service.DepartmentService;
import com.ssm.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeFacade {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;


    public PageInfoResponse<DeptEntity> queryDepartment(DeptEntity deptEntity) {

        PageInfoResponse<DeptEntity> pageInfoResponse = new PageInfoResponse<DeptEntity>();
        try{
            List<DeptEntity> deptEntityList = departmentService.queryDept(deptEntity);
            PageInfo<DeptEntity> pageInfo = new PageInfo<DeptEntity>();
            pageInfo.setList(deptEntityList);
            pageInfoResponse.setPageInfo(pageInfo);
        }catch (Exception e){
            pageInfoResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getCode());
            pageInfoResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getDesc());
        }
        return pageInfoResponse;
    }

    public PageInfoResponse<EmployeeEntity> queryEmployee(EmployeeEntity employeeEntity) {
        PageInfoResponse<EmployeeEntity> pageInfoResponse = new PageInfoResponse<EmployeeEntity>();
        try{
            List<EmployeeEntity> employeeEntityList = employeeService.queryAllEmployee(employeeEntity);
            PageInfo<EmployeeEntity> pageInfo = new PageInfo<EmployeeEntity>();
            pageInfo.setList(employeeEntityList);
            pageInfoResponse.setPageInfo(pageInfo);
        }catch (Exception e){
            pageInfoResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getCode());
            pageInfoResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getDesc());
        }
        return pageInfoResponse;
    }

    public MessageResponse updateEmployee(EmployeeEntity employeeEntity) {
        MessageResponse messageResponse = new MessageResponse();
        try{
            employeeService.updateEmployee(employeeEntity);
        }catch (Exception e){
            messageResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getCode());
            messageResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getDesc());
        }
        return messageResponse;
    }

    public MessageResponse deleteEmployee(Integer id) {
        MessageResponse messageResponse = new MessageResponse();
        try{
            employeeService.deleteEmp(id);
        }catch (Exception e){
            messageResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getCode());
            messageResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getDesc());
        }
        return messageResponse;
    }

    public MessageResponse addEmployee(EmployeeEntity employeeEntity) {
        MessageResponse messageResponse = new MessageResponse();
        try{
            employeeService.addEmployee(employeeEntity);
        }catch (Exception e){
            messageResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getCode());
            messageResponse.setResponseCode(ErrorCode.RPC_CODE_ERROR.getDesc());
        }
        return messageResponse;
    }
}
