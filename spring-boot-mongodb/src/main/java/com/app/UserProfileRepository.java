package com.app;

import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

    @Aggregation(pipeline = {
            "{'$group' : {'_id': '$city' , 'userCount':{'$sum':1} } } }",
            "{'$addFields' : {'city':'$_id'}}",
            "{'$project' : {'_id':0, 'city':1,'userCount':1  }}"
    })
    AggregationResults<UserProfileStat> getUserProfileStats();
}
