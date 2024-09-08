package com.code2go.springboot.cruddemo.dao;

import com.code2go.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{



    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        this.entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a query
        TypedQuery<Employee> query= entityManager.createQuery("FROM Employee",Employee.class);

        //execute query and get all results
        List<Employee> employees= query.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee employee = entityManager.find(Employee.class,theId);
        return employee;    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee employee=entityManager.merge(theEmployee);
        return employee;
    }

    @Override
    public void deleteById(int theId) {
        Employee employee=entityManager.find(Employee.class,theId);
        entityManager.remove(employee);
    }


}
