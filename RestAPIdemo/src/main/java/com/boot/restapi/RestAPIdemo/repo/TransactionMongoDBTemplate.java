package com.boot.restapi.RestAPIdemo.repo;

import com.boot.restapi.RestAPIdemo.dto.GenderAmount;
import com.boot.restapi.RestAPIdemo.dto.JobAmount;
import com.boot.restapi.RestAPIdemo.dto.MerchantAmount;
import com.boot.restapi.RestAPIdemo.dto.StateAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class TransactionMongoDBTemplate {


    @Autowired
    private MongoTemplate mongoTemplate;

    public List<StateAmount> getAmountForCountry() {
        // MongoTemplate pipeline
        GroupOperation groupByState = group("state").sum("amt").as("totalAmount");
        System.out.println(groupByState.count());
        MatchOperation allState = match(new Criteria("state").exists(true));
        ProjectionOperation includes = project("totalAmount").and("state").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmount"));
        Aggregation aggregation = newAggregation(allState, groupByState, sortBySalesDesc, includes);
        AggregationResults<StateAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", StateAmount.class);
        return groupResults.getMappedResults();
    }
    public List<GenderAmount> getAmountForGender()
    {
        // MongoTemplate pipeline
        GroupOperation groupByGender = group("gender").sum("amt").as("totalAmount");
        System.out.println(groupByGender.count());
        MatchOperation allGender = match(new Criteria("gender").exists(true));
        ProjectionOperation includes = project("totalAmount").and("gender").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmount"));
        Aggregation aggregation = newAggregation(allGender, groupByGender, sortBySalesDesc, includes);
        AggregationResults<GenderAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions", GenderAmount.class);
        return groupResults.getMappedResults();
    }


    public List<JobAmount> getAmountForJob()
    {
        // MongoTemplate pipeline
        GroupOperation groupByJob = group("Job").sum("amt").as("totalAmount");
        System.out.println(groupByJob.count());
        MatchOperation allJob = match(new Criteria("Job").exists(true));
        ProjectionOperation includes = project("totalAmount").and("Job").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmount"));
        Aggregation aggregation = newAggregation(allJob, groupByJob, sortBySalesDesc, includes);
        AggregationResults<JobAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions",JobAmount.class);
        return groupResults.getMappedResults();
    }


    public List<MerchantAmount> getAmountForMerchant()
    {
        // MongoTemplate pipeline
        GroupOperation groupByMerchant = group("merchant").sum("amt").as("totalAmount");
        System.out.println(groupByMerchant.count());
        MatchOperation allMerchant = match(new Criteria("merchant").exists(true));
        ProjectionOperation includes = project("totalAmount").and("merchant").previousOperation();
        SortOperation sortBySalesDesc = sort(Sort.by(Sort.Direction.DESC, "totalAmount"));
        Aggregation aggregation = newAggregation(allMerchant, groupByMerchant, sortBySalesDesc, includes);
        AggregationResults<MerchantAmount> groupResults = mongoTemplate.aggregate(aggregation, "transactions",MerchantAmount.class);
        return groupResults.getMappedResults();
    }



}
