package com.rsqd.springbootwebrestfulcrud.control;


import com.rsqd.springbootwebrestfulcrud.dao.DepartmentDao;
import com.rsqd.springbootwebrestfulcrud.dao.EmployeeDao;
import com.rsqd.springbootwebrestfulcrud.entities.Department;
import com.rsqd.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao ;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees= employeeDao.getAll();


        //put in the request field
        model.addAttribute("emps",employees);
        //thymeleaf will construct the path
        //classpath://templates/xxxx.html
        return "emp/list";


    }

    //to add emp page
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //first find out all departments

        Collection<Department> departments=departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //adding emp page
        return "emp/add";
    }

    //add emp
    @PostMapping("/emp")
    public String addemp(Employee employee){//springMVC automatically binds request fields to object fields()

        //System.out.println(employee);
        employeeDao.save(employee);
        //back to the (emps) list page
        return "redirect:/emps";
    }
}
