package com.antsdouble.dao;

import com.antsdouble.bean.Employee;

import java.util.List;

public interface EmployeeDynamicMapper {

    public List<Employee> getEmpByCondition(Employee employee);

    public List<Employee> getEmpByConditionChoose(Employee employee);

    public  void updateEmpByConditionSet(Employee employee);

    public  List<Employee> getEmpByConditionForeach(List<Integer> list);
}
