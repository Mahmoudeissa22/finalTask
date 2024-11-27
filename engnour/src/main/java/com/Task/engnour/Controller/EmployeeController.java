package com.Task.engnour.Controller;
import com.Task.engnour.Entity.Employee;
import com.Task.engnour.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/task")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId) {
        Optional<Employee> employee = employeeService.findById(employeeId);
        if (employee.isEmpty()) {
            throw new RuntimeException("Employee not found" + employeeId);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeService.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Optional<Employee> theEmployee = employeeService.findById(employeeId);
        if (theEmployee.isEmpty()) {
            throw new RuntimeException("Employee id not found" + employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee Id: " + employeeId;
    }
}
