package com.boot.restapi.RestAPIdemo.controller;

import com.boot.restapi.RestAPIdemo.dto.StateAmount;
import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.entity.Transactions;
import com.boot.restapi.RestAPIdemo.service.CustomerService;
import com.boot.restapi.RestAPIdemo.service.TransactionService;
import com.boot.restapi.RestAPIdemo.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/Transactions")
public class TransactionsRestController {
    @Autowired

    private TransactionService transactionService;
    @RequestMapping(path="/findAllTransactions", method = RequestMethod.GET)
    public List<Transactions> findAllTransactions(){
        return this.transactionService.getAllTransactions();
    }
    @RequestMapping(path = "/findTransactionsCount",method = RequestMethod.GET)
    public long findTransactionsCount(){
        return this.transactionService.getTransactionsCount();
    }

    @GetMapping("getTransactionByTrans_num/{transnum}")
    public Transactions getTransactionByTrans_num(@PathVariable int transnum){
        return transactionService.getTransactionByTrans_num(transnum);
    }
    @GetMapping("getTransactionByFirstName")
    public List<Transactions> getTransactionByFirstName(@RequestParam(required = false) String first){
        if (first==null){
            return transactionService.getAllTransactions();
        }
        return transactionService.getTransactionByfirst(first);
    }
    @PostMapping("addTransactionController")
    public Transactions addTransactionController(@RequestBody Transactions transactions){
       return transactionService.addTransaction(transactions);
    }
    @DeleteMapping("deleteCustomerByTrans_num/{transnum}")
    public long deleteCustomerByTrans_num(@PathVariable int transnum){
        return transactionService.deleteByTrans_num(transnum);
    }
    @PutMapping("updateTransactionController")
    public Transactions updateTransactionController(@RequestParam int transnum,@RequestBody Transactions transactions){
        return transactionService.updateById(transnum,transactions);}

    @GetMapping("getTransactionsInAmountRangeController")
    public List<Transactions> getTransactionsInAmountRangeController(@RequestParam double from, @RequestParam double to){
        return transactionService.getTransactionsInAmountRange(from, to);
    }
    @GetMapping("getTransactionByStatWithAmountRangeAndSortController")
    public List<Transactions> getTransactionByStatWithAmountRangeAndSortController(@RequestParam String state,@RequestParam double from, @RequestParam double to){
        return transactionService.getTransactionByStateWithAmountRangeAndSort(state, from, to);
    }
    @GetMapping("getByStateAmount")
    public ResponseEntity<List<StateAmount>> getByStateAmount(){
        return ResponseEntity.ok(transactionService.getAmountForCountry());
    }

//    @DeleteMapping("deleteEmployeeById/{customerId}")
//    public ResponseEntity<Object> deleteEmployeeById(@PathVariable int customerid)
//    {
//        Map<Messages, String> map = new HashMap<>();
//        try {
//            map.put(Messages.SUCCESS, "Employee deleted successfully");
//            this.customerService.deleteById(customerid);
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
//        } catch (Exception e) {
//            map.put(Messages.FAILURE, e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
//        }
//    }
}
