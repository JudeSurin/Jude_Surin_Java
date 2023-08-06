package com.company.company.repository;

import com.company.company.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Registers class with string for its purpose
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
//access to CRUD - Create, Read, Update, Delete
    // Find customer by state
    List<Customer> findCustomerBystate (String state);


    org.hibernate.mapping.List findCustomerByState(String state);
}

