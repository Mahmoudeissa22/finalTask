package com.Task.engnour.Controller;

import com.Task.engnour.Entity.Employee;
import com.Task.engnour.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class EmployeeControllerMVC {
    private final EmployeeService employeeService;

    public EmployeeControllerMVC(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployee = employeeService.findAll();
        theModel.addAttribute("employees" , theEmployee);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd (Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId , Model themodel){
        Optional<Employee> theEmployee=employeeService.findById(theId);
        themodel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee (@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);
        return "redirect:/task/list";
    }


    @GetMapping("/delete")
    public String delete (@RequestParam("employeeId") int theId){

        employeeService.deleteById(theId);
        return "redirect:/task/list";
    }

}

