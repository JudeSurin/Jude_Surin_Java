package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    /**
     * Company ID number
     */
    private int id;

    /**
     * Company Name
     */
    private String name;

    /**
     * contains customer's charges
     */
    private final List<AccountRecord> charges = new ArrayList<>();

    /**
     * getting ID number
     * @return identification number of customer
     */
    public int getId() {
        return id;
    }

    /**
     * setting ID number
     * @param id id number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getting customer name
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * setting the customer's name
     * @param name Customer's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * loops through charges list and returns the account balance
     * @return account balance
     */
    public int getBalance() {
        int total = 0;
        for (var charge : charges) {
            total += charge.getCharge();
        }
        return total;
    }

    /**
     * adds charge to charges list
     *
     * @param charge a charge amount
     * @param chargeDate date charge was made
     */
    public void addCharges(int charge, String chargeDate){
        AccountRecord record = new AccountRecord();
        record.setCharge(charge);
        record.setChargeDate(chargeDate);
        charges.add(record);
    }

    /**
     * gets customer's full account record
     * @return account record
     */
    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return "id: " + id + " name: " + name + " balance: " + getBalance();
    }
}
