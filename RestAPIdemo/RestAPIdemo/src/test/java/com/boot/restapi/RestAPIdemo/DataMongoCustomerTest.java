package com.boot.restapi.RestAPIdemo;

import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataMongoTest
public class DataMongoCustomerTest {
    @Autowired
    private CustomerRepository repo;

    @Test
    public void findCustomerByfirstSpec() throws ParseException {
        repo.save(new Customer("hi12","hello","M","Cook",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"),987));
        List<Customer> response1 = repo.findCustomerByfirst("hi12");
        for (Customer response: response1){
        assertEquals("hello",response.getLast());
        assertEquals("M",response.getGender());}
    }
    @Test
    public void collectionNotEmpty(){
        assertThat(repo.findAll()).isNotEmpty();
    }
}
