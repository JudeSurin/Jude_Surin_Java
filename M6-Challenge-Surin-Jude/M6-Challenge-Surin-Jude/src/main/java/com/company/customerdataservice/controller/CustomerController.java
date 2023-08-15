package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.apache.commons.lang3.ObjectUtils;
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
        @ResponseStatus(HttpStatus.ACCEPTED)
        public Customer getCustomer(@PathVariable int id) {
            Optional<Customer> customer = repo.findById(id);
            if (customer.isPresent()) {
                return customer.get();
            } else {
                return null;
            }
        }

        @PostMapping("/customer")
        @ResponseStatus(HttpStatus.CREATED)
        public Customer createCustomer(@RequestBody Customer newCustomer) {
            return repo.save(newCustomer);
        }

        @PutMapping("/customer")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
            return repo.save(updatedCustomer);
        }

        @DeleteMapping("/customer/{id}")
        public void deleteCustomer(@PathVariable int id) {
         repo.deleteById(id);
        }

        @GetMapping("/customers/bystate/{state}")
        public List<Customer> getCustomersByState(@PathVariable String state) {
            return repo.findCustomerBystate(state);
        }
    }

