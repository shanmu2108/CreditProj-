package com.boot.restapi.RestAPIdemo;

import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.repo.CustomerRepository;
import com.boot.restapi.RestAPIdemo.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class Customerspec {
    @Mock
    CustomerRepository repo;
    @InjectMocks
    CustomerService service;

    List<Customer> customerlist;
    Customer c1,c2,c3;
    //Arranging
    @BeforeEach
    public void befEach(){
        MockitoAnnotations.initMocks(this);
    }
    @BeforeEach
    public void setUp() throws ParseException {
        c1=new Customer("hi1","hello","M","Cook",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"),986);
        c2=new Customer("hi2","hello","M","Cook",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"),987);
        c3=new Customer("hi3","hello","M","Cook",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"),988);
        customerlist= Arrays.asList(c1,c2,c3);
    }

    @Test
    public void getallCustomersSpec(){
        when(repo.findAll()).thenReturn(customerlist);
        List<Customer> recieved = service.getAllCustomers();
        assertEquals(recieved.size(),customerlist.size());
    }
    @Test
    public void getCustomerByIdSpec(){
        when(repo.findBycustomerid(987)).thenReturn(c2);
        Customer received = service.getCustomerByCustomerId(987);
        assertEquals(c2,received);
    }
    @Test
    public void addCustomerSpec(){

    when(repo.insert(c1)).thenReturn(c1);
    service.addCustomer(c1);
    assertEquals(4,customerlist.size()+1);
    }
    @Test
    public void updateByIdSpec(){
        when(repo.findBycustomerid(987)).thenReturn(c2);
        when(repo.save(c3)).thenReturn(c3);
        Customer cus= service.updateById(987,c3);
        assertEquals(c3.getCustomerid(),cus.getCustomerid());
    }
    @Test
    public void deleteByIdSpec(){

        when(repo.deleteCustomerBycustomerid(987)).thenReturn((long)1);
        service.deleteById(987);
        assertEquals(2,customerlist.size()-1);
    }
}
