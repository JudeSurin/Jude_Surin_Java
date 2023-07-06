package com.company;

import org.testng.annotations.Test;

public class CustomerTest {

    @Test
    public void testBalance() {
        Customer customer = new Customer();

        //Create some AccountRecords and add them to the customer
        Object AccountRecord1 = newAccountRecord();
        AccountRecord record1 = null;
        record1.setCharge(1000);

        AccountRecord record2 = new AccountRecord();
        record2.setCharge(-500);

        customer.getCharges().add(record1);
        customer.getCharges().add(record2);

        //Calculate the expected balance
        int expectedBalance = 1000 - 500;

        // Call the getBalance() method and assert the result
        asserEquals(expectedBalance, customer.getBalance());
    }

    private Object newAccountRecord() {
        return null;
    }

    private void asserEquals(int expectedBalance, int balance) {
    }
}
