package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class AccountManager {

    /**
     * Stores initial list of customers
     */
    private final List <String[]> customerData;

    /**
     * Stores updated list of customers as Customer type
     */
    private final List <Customer> convertedCustomerData;
    public AccountManager(List<String[]> customerData) {
        this.customerData = customerData;
        convertedCustomerData = new ArrayList<>();
    }

    /**
     * adding information from constructor to new Customer List data structure
     */
    public void addCustomerInformation() {
        customerData.forEach(customer-> {
            String name = customer[1];
            int id = Integer.parseInt(customer[0]);
            int charge = Integer.parseInt(customer[2]);
            String description = customer[3];

            Optional<Customer> existingCustomer = convertedCustomerData.stream()
                    .filter(c -> Objects.equals(c.getId(), id))
                    .findFirst();

            if (existingCustomer.isPresent()) {
                Customer data = existingCustomer.get();
                data.addCharges(charge, description);
            } else {
                Customer newCustomer = new Customer();
                newCustomer.setId(id);
                newCustomer.setName(name);
                newCustomer.addCharges(charge, description);
                convertedCustomerData.add(newCustomer);
            }
        });
    }

    /**
     * allows user to view list of Customers
     * @return List of Customers
     */
    public List<Customer> viewCustomers() {
        return Collections.unmodifiableList(convertedCustomerData);
    }

    /**
     * filters customer balances greater than 0 and returns them
     * @return List of positive accounts
     */
    public List<Customer> positiveAccounts() {
        return convertedCustomerData.stream()
                .filter(customer -> customer.getBalance() > 0)
                .collect(Collectors.toList());
    }

    /**
     * filters customer balances less than 0 and returns them
     * @return List of negative accounts
     */
    public List<Customer>  negativeAccounts() {
        return convertedCustomerData.stream()
                .filter(customer -> customer.getBalance() < 0)
                .collect(Collectors.toList());
    }
}
