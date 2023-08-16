package com.boot.restapi.RestAPIdemo.repo;

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



}
