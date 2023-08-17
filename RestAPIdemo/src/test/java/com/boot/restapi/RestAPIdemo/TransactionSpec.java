package com.boot.restapi.RestAPIdemo;

import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.entity.Transactions;
import com.boot.restapi.RestAPIdemo.repo.TransactionsRepository;
import com.boot.restapi.RestAPIdemo.service.TransactionService;
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
public class TransactionSpec {
    @Mock
    TransactionsRepository repo;
    @InjectMocks
    TransactionService service;

    List<Transactions> transactionslist;
    Transactions t1,t2,t3;
    @BeforeEach
    public void befEach(){
        MockitoAnnotations.initMocks(this);
    }
    @BeforeEach
    public void setUp() throws ParseException {
        t1=new Transactions("23/02/2020 21:38",40.1,1900001,891,"Chennai","TN",12465,"Aachi","Food","hi","hello","F","Salesman","27/05/1993");
        t2=new Transactions("23/02/2020 21:38",40.1,1900002,891,"Chennai","TN",12465,"Aachi","Food","hi","hello","F","Salesman","27/05/1993");
        t3=new Transactions("23/02/2020 21:38",40.1,1900003,891,"Chennai","TN",12465,"Aachi","Food","hi","hello","F","Salesman","27/05/1993");
        transactionslist= Arrays.asList(t1,t2,t3);
    }
    @Test
    public void getAllTransactionsSpec(){
        when(repo.findAll()).thenReturn(transactionslist);
        List<Transactions> recieved = service.getAllTransactions();
        assertEquals(recieved.size(),transactionslist.size());
    }
    @Test
    public void getTransactionByTransnumSpec(){
        when(repo.findBytransnum(1900002)).thenReturn(t2);
        Transactions received = service.getTransactionByTrans_num(1900002);
        assertEquals(t2,received);
    }
    @Test
    public void addTransactionSpec(){

        when(repo.insert(t1)).thenReturn(t1);
        service.addTransaction(t1);
        assertEquals(4,transactionslist.size()+1);
    }
    @Test
    public void updateByIdSpec(){
        when(repo.findBytransnum(1900002)).thenReturn(t2);
        when(repo.save(t2)).thenReturn(t3);
        Transactions trans= service.updateById(1900002,t3);
        assertEquals(t3.getTrans_num(),trans.getTrans_num());
    }
    @Test
    public void deleteByIdSpec(){

        when(repo.deleteTransactionsBytransnum(1900002)).thenReturn((long)1);
        service.deleteByTrans_num(1900002);
        assertEquals(2,transactionslist.size()-1);
    }
}
