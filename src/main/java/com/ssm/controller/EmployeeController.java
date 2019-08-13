package com.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.entity.EmployeeEntity;
import com.ssm.service.EmployeeService;
import com.ssm.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/employ")
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

    @RequestMapping("/list")
    public String queryAllEmployee(Integer pagenum, Model model){

        PageHelper.startPage(pagenum, 5);
        List<EmployeeEntity> entityList = employeeService.queryAllEmployee();
        PageInfo pageInfo = new PageInfo(entityList,5);
        model.addAttribute(pageInfo);
        return "list";
    }

    @ResponseBody
    @RequestMapping("/queryEmployee")
    public PageInfo queryEmployee(Integer pagenum){

        PageHelper.startPage(pagenum, 5);
        List<EmployeeEntity> entityList = employeeService.queryAllEmployee();
        PageInfo pageInfo = new PageInfo(entityList,5);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping("/addEmployee")
    public Msg addEmployee(EmployeeEntity employeeEntity){
        try{
             employeeService.addEmployee(employeeEntity);
        }catch (Exception e){
            return Msg.fail();
        }
        return Msg.success();
    }

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id")Integer id){

        EmployeeEntity employeeEntity = employeeService.queryEmployee(id);
        return Msg.success().add("emp", employeeEntity);
    }

    @ResponseBody
    @RequestMapping(value="/update/{empId}",method=RequestMethod.PUT)
    public Msg saveEmp(EmployeeEntity employee, HttpServletRequest request){
        System.out.println("请求体中的值："+request.getParameter("gender"));
        System.out.println("将要更新的员工数据："+employee);
        employeeService.updateEmployee(employee);
        return Msg.success()	;
    }

    /**
     * 单个批量二合一
     * 批量删除：1-2-3
     * 单个删除：1
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{ids}",method=RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids")String ids){
        //批量删除
        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<Integer>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                employeeService.deleteEmp(Integer.parseInt(string));
            }
        }else{
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Msg.success();
    }

}
