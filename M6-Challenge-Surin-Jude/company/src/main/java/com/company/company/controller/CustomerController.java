package com.company.company.controller;

import com.company.company.model.Customer;
import com.company.company.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @GetMapping("/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        Optional<Customer> customer = repo.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        Customer createdCustomer = repo.save(newCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer updatedCustomer) {
        Optional<Customer> existingCustomer = repo.findById(id);
        if (existingCustomer.isPresent()) {
            updatedCustomer.setId(id);
            Customer savedCustomer = repo.save(updatedCustomer);
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        Optional<Customer> existingCustomer = repo.findById(id);
        if (existingCustomer.isPresent()) {
            repo.delete(existingCustomer.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/customers/bystate/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return (List<Customer>) repo.findCustomerByState(state);
    }
}
