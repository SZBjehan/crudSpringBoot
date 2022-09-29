package com.example.crud.service;

import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee Save(Employee emp){
        return employeeRepository.save(emp);
    }

    public Employee getEmployee(int id){
        return employeeRepository.findById(id).get();
    }
//    Update
    public Employee update(Employee employee){
        Employee emp = employeeRepository.findById(employee.getId()).get();
        emp.setName(employee.getName());
        emp.setAge(employee.getAge());

        return employeeRepository.save(emp);

    }
//    delete
    public  String delete(int id){
        employeeRepository.deleteById(id);
        return "Entity deleted"+ id;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
}
