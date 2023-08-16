package com.boot.restapi.RestAPIdemo;

import com.boot.restapi.RestAPIdemo.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerSpec {
    @Autowired
    TestRestTemplate template;
    @Test
    public void findAllCustomersTest(){
        ResponseEntity<List<Customer>> response= template.exchange("/Customer/get",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Customer>>() {});
        List<Customer> rescus=response.getBody();
        assertEquals(985,rescus.size());
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }
    @Test //Vetri
    public void addCustomerControllerTest() throws ParseException, URISyntaxException {
        TestRestTemplate template1 =new TestRestTemplate();
        URI uri = new URI("http://localhost:8080/Customer/hello1");
        Customer customer1=new Customer("hi1","hello","M","Cook",new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"),986);
        ResponseEntity<Customer> response = template1.postForEntity(uri,customer1,Customer.class);
         assertEquals("hi1",response.getBody().getFirst());
    }
}
