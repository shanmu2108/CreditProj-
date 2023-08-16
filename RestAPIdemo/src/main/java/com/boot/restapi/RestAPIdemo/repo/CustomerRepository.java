package com.boot.restapi.RestAPIdemo.repo;


import com.boot.restapi.RestAPIdemo.entity.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {
    //public List<Customer> findByCustomer_Id(long customer_id);
//    public Optional<Customer> findCustomerByFirst(String first);
//    public List<Customer> findCustomerBygender(String gender);

    public Customer findBycustomerid(int customerid);
    public List<Customer> findCustomerByfirst(String first);

    public Long deleteCustomerBycustomerid(int customerid);
    public Long deleteCustomerByfirst(String first);



}
