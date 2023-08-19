package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository repo;

    @BeforeEach
    //own method
    void setUp() {
        repo.deleteAll();

    }

    @Test
    void findCustomerBystate() {

    }

    @Test
    void createCustomer(){
        // New container, placed object returned from amking a call to the customer constructor
        Customer customer = new Customer();
        customer.setFirstName("Jude");
        customer.setLastName("Surin");
        customer.setEmail("Jusurin21@gmail.com");
        customer.setCompany("Netflix");
        customer.setPhone("786-659-3009");
        customer.setAddress1("1341Ne 152nd st, biscayne");
        customer.setAddress2("NA");
        customer.setCity("Aventura");
        customer.setState("Florida");
        customer.setPostalCode("33162");
        customer.setCountry("United States");

        // For the whole database. Also passes back
        customer = repo.save(customer);

        Optional<Customer> customer1 = repo.findById(customer.getCustomerId());

        assertEquals(((Optional<?>) customer1).get(), customer);
    }
}