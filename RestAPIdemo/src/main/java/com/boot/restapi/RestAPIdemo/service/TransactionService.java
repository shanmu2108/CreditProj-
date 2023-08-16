package com.boot.restapi.RestAPIdemo.service;


import com.boot.restapi.RestAPIdemo.dto.GenderAmount;
import com.boot.restapi.RestAPIdemo.dto.JobAmount;
import com.boot.restapi.RestAPIdemo.dto.MerchantAmount;
import com.boot.restapi.RestAPIdemo.dto.StateAmount;
import com.boot.restapi.RestAPIdemo.entity.Customer;
import com.boot.restapi.RestAPIdemo.entity.Transactions;
import com.boot.restapi.RestAPIdemo.repo.TransactionMongoDBTemplate;
import com.boot.restapi.RestAPIdemo.repo.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionsRepository transactionsRepository;
    @Autowired
    private TransactionMongoDBTemplate template;
    public long getTransactionsCount(){
        return  transactionsRepository.count();
    }
    public List<Transactions> getAllTransactions(){
        return this.transactionsRepository.findAll();}

    public Transactions getTransactionByTrans_num(int transnum){
        return this.transactionsRepository.findBytransnum(transnum);
    }
    public List<Transactions> getTransactionByfirst(String first){
        return this.transactionsRepository.findCustomerByfirst(first);}

    public Transactions addTransaction(Transactions transactions){
        return this.transactionsRepository.insert(transactions);}
    public long deleteByTrans_num(int transnum){
        return this.transactionsRepository.deleteTransactionsBytransnum(transnum);}
    public Transactions updateById(int transnum, Transactions transactions){
        Transactions updatedtransaction = transactionsRepository.findBytransnum(transnum);
        updatedtransaction.setAmt(transactions.getAmt());
        updatedtransaction.setCategory(transactions.getCategory());
        updatedtransaction.setCity(transactions.getCity());
        updatedtransaction.setLast(transactions.getLast());
        updatedtransaction.setGender(transactions.getGender());
        updatedtransaction.setFirst(transactions.getFirst());
        updatedtransaction.setCity_population(transactions.getCity_population());
        updatedtransaction.setDob(transactions.getDob());
        updatedtransaction.setMerchant(transactions.getMerchant());
        updatedtransaction.setJob(transactions.getJob());
        updatedtransaction.setState(transactions.getState());
        updatedtransaction.setCustomer_id(transactions.getCustomer_id());
        updatedtransaction.setTrans_date_trans_time(transactions.getTrans_date_trans_time());
        transactionsRepository.save(updatedtransaction);
        return updatedtransaction;
    }
    public List<Transactions> getTransactionsInAmountRange(double from, double to){
        return this.transactionsRepository.findTransactionsInAmountRange(from,to);
    }
    public List<Transactions> getTransactionByStateWithAmountRangeAndSort(String state, double from, double to){
        return this.transactionsRepository.findTransactionByStateWithAmountRangeAndSort(state,from,to);
    }
    public List<StateAmount> getAmountForCountry(){
        return template.getAmountForCountry();
    }
    public List<GenderAmount> getAmountForGender(){
        return template.getAmountForGender();
    }public List<JobAmount> getAmountForJob(){
        return template.getAmountForJob();
    }public List<MerchantAmount> getAmountForMerchant(){
        return template.getAmountForMerchant();
    }


 }


