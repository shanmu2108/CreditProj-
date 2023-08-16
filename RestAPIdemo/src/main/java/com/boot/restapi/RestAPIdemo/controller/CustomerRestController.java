package com.boot.restapi.RestAPIdemo.controller;

import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.exception.RecordNotFoundException;
import com.boot.restapi.RestAPIdemo.repo.CustomerRepository;
import com.boot.restapi.RestAPIdemo.service.CustomerService;
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
@RequestMapping("/Customer")
public class CustomerRestController {
    @Autowired

    private CustomerService customerService;
    @RequestMapping(path="/findAllCustomers", method = RequestMethod.GET)
    public List<Customer> findAllCustomers(){
        return this.customerService.getAllCustomers();
    }
    @RequestMapping(path = "/findCustomersCount",method = RequestMethod.GET)
    public long findCustomersCount(){
        return this.customerService.getCustomersCount();
    }

    //new Customer("hi","helo","M","Electrician", new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1970"),985);

    @GetMapping("getCustomerById/{customerid}")
    public Customer getCustomerById(@PathVariable int customerid){
        return customerService.getCustomerByCustomerId(customerid);}
    @GetMapping("getCustomerByFirstName")
    public List<Customer> getCustomerByFirstName(@RequestParam(required = false) String first){
        if (first==null){
            return customerService.getAllCustomers();
        }
        return customerService.getCustomerByfirst(first);
    }
    @PostMapping("addCustomerController")
    public Customer addCustomerController(@RequestBody Customer customer){
       return customerService.addCustomer(customer);
    }
    @DeleteMapping("deleteCustomerById/{customerid}")
    public long deleteCustomerById(@PathVariable int customerid){
        return customerService.deleteById(customerid);
    }
    @PutMapping("updateCustomerController")
    public Customer updateCustomerController(@RequestParam int customerid,@RequestBody Customer customer){
        return customerService.updateById(customerid,customer);}
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
