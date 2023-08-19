package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    CustomerRepository repo;

    Customer customer;
    @BeforeEach
    void setUp() {
        //Initalize and put in memory
        customer = new Customer();
        customer.setFirstName("Jude");
        customer.setLastName("Surin");
        customer.setCountry("USA");
        customer.setState("Seattle");
        customer.setCity("Washington");
        customer.setPostalCode("33221");
        customer.setPhone("3242123343");
        customer.setCompany("Netflix");
        customer.setEmail("Jsuri018@fiu.edu");
        customer.setAddress1("1341Ne 152nd st");
        customer.setAddress2("21055NW 125th st");

    }

    @Test
    void getCustomersByState() throws Exception {
        mockMvc.perform(get("/customers/bystate/state"))
                .andExpect(status().isAccepted());

    }

    @Test
    void createCustomer() throws Exception {
        String inputJSON = objectMapper.writeValueAsString(customer);
        mockMvc.perform(post("/customer")
                .content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isCreated());
    }
    @Test
    void updateCustomer() throws Exception {
        customer.setId(7);
        String inputJSON = objectMapper.writeValueAsString(customer);
        mockMvc.perform(put("/customer")
                        .content(inputJSON).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNoContent());
    }

    @Test
    void deleteCustomer() throws Exception {
        customer.setId(2);
        mockMvc.perform(delete("/customer/2"))
                .andDo(print()).andExpect(status().isNoContent());
    }


    @Test
    public void testGetCustomerById() throws Exception {
        mockMvc.perform(get("/customer/1"))
                .andExpect(status().isAccepted());
//        Customer customer = new Customer();
//        customer.setFirstName("Jude");
//        customer.setLastName("Surin");
//        customer.setEmail("JudeSurin4@gmail.com");
//        customer.setCompany("Netflix");
//        customer.setPhone("786-659-3009");
//        customer.setAddress1("1341Ne 152nd st");
//        customer.setCity("Seattle");
//        customer.setState("DC");
//        customer.setPostalCode("34122");
//        customer.setCountry("USA");
//        Session customerRepository = null;
//        Customer savedCustomer = (Customer) customerRepository.save(customer);
//
//        mockMvc.perform(get("/customer/{id}", savedCustomer.getId()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.firstName").value("Jude"))
//                .andExpect(jsonPath("$.lastName").value("Surin"))
//                .andExpect(jsonPath("$.email").value("JudeSurin4@gmail.com"))
//                .andExpect(jsonPath("$.company").value("Netflix"))
//                .andExpect(jsonPath("$.phone").value("7866593009"))
//                .andExpect(jsonPath("$.address1").value("789 Elm St"))
//                .andExpect(jsonPath("$.address2").value("Unit 101"))
//                .andExpect(jsonPath("$.city").value("Seattle"))
//                .andExpect(jsonPath("$.state").value("DC"))
//                .andExpect(jsonPath("$.postalCode").value("34122"))
//                .andExpect(jsonPath("$.country").value("USA"));
    }

}


