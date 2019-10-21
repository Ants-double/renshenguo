package com.antsdouble.dao;

import com.antsdouble.bean.Employee;

public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public Employee getEmpByIdAndLastName(Integer id, String lastName);

    public Employee getEmpByIdAndDept(Integer id);

    public  Employee getEmpByIdStep(Integer id);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);

}
