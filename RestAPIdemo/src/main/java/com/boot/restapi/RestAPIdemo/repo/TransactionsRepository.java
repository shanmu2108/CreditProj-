package com.boot.restapi.RestAPIdemo.repo;


import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.entity.Transactions;
import com.boot.restapi.RestAPIdemo.service.TransactionService;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionsRepository extends MongoRepository<Transactions, ObjectId> {
    public Transactions findBytransnum(int transnum);
    public List<Transactions> findCustomerByfirst(String first);

    public Long deleteTransactionsBytransnum(int transnum);
    public Long deleteTransactionsByfirst(String first);
    @Query("{'amt' : {$gte : ?0, $lte : ?1}}")
    List<Transactions> findTransactionsInAmountRange(double from, double to);
    @Aggregation(pipeline = {
            "{'$match':{'state':?0, 'amt': {$gt: ?1, $lt:?2} }}",
//            "{'$sample':{size:10}}",
            "{'$sort':{'amt':-1}}"
    })
    List<Transactions> findTransactionByStateWithAmountRangeAndSort(String state, double from, double to);
}
