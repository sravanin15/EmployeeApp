package service;

import java.util.List;

import Entity.Employee;
public interface ServiceImpl {
public List<Employee> addEmployee(List<Employee> list);
public List<Employee> updateEmployeeSalary(List<Employee> list);
public Employee getEmployeeById(List<Employee> list);
public void getAllEmployee(List<Employee> list);
public List<Employee> deleteEmployee(List<Employee> list);
}
