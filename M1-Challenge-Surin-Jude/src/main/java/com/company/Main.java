package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    // Hardcoded list of customer data
    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"}
            new String []{"1", "Wayne Enterprises", "18000"}, 
            new String[] {"3","Ace Chemical","-48000"},
            new String[] {"3","Ace Chemical","-95000"},
            new String[] {"1","Wayne Enterprises","175000"},
            new String[] {"1","Wayne Enterprises","-35000"},
            new String[] {"1","Wayne Enterprises","-64000"},
            new String[] {"3","Ace Chemical","70000"},
            new String[] {"2","Daily Planet","56000"},
            new String[] {"2","Daily Planet","-33000"},
            new String[] {"1","Wayne Enterprises","10000"},
            new String[] {"2","Daily Planet","33000"},
            new String[] {"3","Ace Chemical","140000"},
            new String[] {"2","Daily Planet","5000"},
            new String[] {"3","Ace Chemical","-82000"},
            new String[] {"1","Wayne Enterprises","10000"}
    );

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        // Iterate through customerData, convert it to Customer objects, and add them to the customers list
        for (String[] data : customerData) {
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int charge = Integer.parseInt(data[2]);
            Customer customer = findOrCreateCustomer(customers, id, name);
            customer.addCharge(charge);
        }

        // Print positive and negative account balances
        System.out.println("Positive accounts:");
        for (Customer customer : customers) {
            if (customer.getBalance() > 0) {
                System.out.println(customer);
            }
        }

        System.out.println("Negative accounts:");
        for (Customer customer : customers) {
            if (customer.getBalance() < 0) {
                System.out.println(customer);
            }
        }
    }

    // Method to find an existing customer or create a new customer if not found
    private static Customer findOrCreateCustomer(List<Customer> customers, int id, String name) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        Customer newCustomer = new Customer();
        newCustomer.setId(id);
        newCustomer.setName(name);
        customers.add(newCustomer);
        return newCustomer;
    }
}
