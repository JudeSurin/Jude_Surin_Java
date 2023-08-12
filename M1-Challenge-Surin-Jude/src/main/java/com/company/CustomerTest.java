package com.company;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {

    private static final List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2031"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    AccountManager manager = new AccountManager(customerData);


    @Test
    void getBalance() {
        manager.addCustomerInformation();
        assertEquals(124000, manager.viewCustomers().get(0).getBalance());
        assertEquals(53500, manager.viewCustomers().get(1).getBalance());
        assertEquals(-15000, manager.viewCustomers().get(2).getBalance());

    }

    @Test
    void testToString() {
        manager.addCustomerInformation();
        assertEquals("id: 1 name: Wayne Enterprises balance: 124000", manager.viewCustomers().get(0).toString());
        assertEquals("id: 2 name: Daily Planet balance: 53500", manager.viewCustomers().get(1).toString());
        assertEquals("id: 3 name: Ace Chemical balance: -15000", manager.viewCustomers().get(2).toString());
    }
}
