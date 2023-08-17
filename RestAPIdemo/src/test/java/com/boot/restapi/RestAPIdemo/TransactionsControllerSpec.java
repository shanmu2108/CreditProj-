package com.boot.restapi.RestAPIdemo;

import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.entity.Transactions;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TransactionsControllerSpec {
    @Autowired
    TestRestTemplate template;
    @Test
    public void findAllTransactionsTest(){
        ResponseEntity<List<Transactions>> response= template.exchange("/Transactions/findAllTransactions",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Transactions>>() {});
        List<Transactions> rescus=response.getBody();
        assertEquals(1048575,rescus.size());
        assertEquals(HttpStatus.OK,response.getStatusCode());

    }
    @Test //Vetri
    public void addTransactionControllerTest() throws ParseException, URISyntaxException {
        TestRestTemplate template1 =new TestRestTemplate();
        URI uri = new URI("http://localhost:8080/Transactions/addTransactionController");
        Transactions transactions1=new Transactions("23/02/2020 21:38",40.1,1900001,891,"Chennai","TN",12465,"Aachi","Food","hi","hello","F","Salesman","27/05/1993");
        ResponseEntity<Transactions> response = template1.postForEntity(uri,transactions1,Transactions.class);
        assertEquals(1900001,response.getBody().getTrans_num());
    }
}
