package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Hardcoded list of customer data
    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"}
            // Additional customer data...
    );

    public static void main(String[] args) {
        // Convert the customer data into a list of Customer objects
        List<Customer> customers = convertDataToCustomers(customerData);

        System.out.println("Positive accounts:");
        printPositiveAccounts(customers);

        System.out.println("Negative accounts:");
        printNegativeAccounts(customers);
    }

    private static List<Customer> convertDataToCustomers(List<String[]> customerData) {
        // List to store the converted Customer objects
        List<Customer> customers = new ArrayList<>();

        // Iterate through each row of customer data
        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int charge = Integer.parseInt(data[2]);
            String chargeDate = data[3];

            // Check if the customer already exists
            Customer existingCustomer = findCustomer(customers, id);
            if (existingCustomer != null) {
                // Add the new AccountRecord to the existing Customer
                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(charge);
                accountRecord.setChargeDate(chargeDate);
                existingCustomer.getCharges().add(accountRecord);
            } else {
                // Create a new Customer and add the AccountRecord
                Customer newCustomer = new Customer();
                newCustomer.setId(id);
                newCustomer.setName(name);
                AccountRecord accountRecord = new AccountRecord();
                accountRecord.setCharge(charge);
                accountRecord.setChargeDate(chargeDate);
                newCustomer.getCharges().add(accountRecord);
                customers.add(newCustomer);
            }
        }

        return customers;
    }

    private static Customer findCustomer(List<Customer> customers, int id) {
        // Find a Customer by their ID in the list of Customers
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    private static void printPositiveAccounts(List<Customer> customers) {
        // Print customers with positive account balances
        for (Customer customer : customers) {
            if (customer.getBalance() > 0) {
                System.out.println(customer);
            }
        }
    }

    private static void printNegativeAccounts(List<Customer> customers) {
        // Print customers with negative account balances
        for (Customer customer : customers) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
            }
        }
    }
}
