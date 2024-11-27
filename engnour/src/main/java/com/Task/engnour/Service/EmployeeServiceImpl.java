package com.Task.engnour.Service;

import com.Task.engnour.Entity.Employee;
import com.Task.engnour.Repository.EmployeeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findById(int theId) {
        return employeeRepo.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        employeeRepo.deleteById(theId);

    }


}
