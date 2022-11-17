package com.app;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<UserProfile> getAllUSerProfiles() {
        return mongoTemplate.findAll(UserProfile.class);
    }

    public List<UserProfile> getUserProfiles(String state, String city) {
        Query query = new Query();
        query.addCriteria(Criteria.where("state").is(state).and("city").is(city));
        return mongoTemplate.find(query, UserProfile.class);
    }

    public List<UserProfileStat> getUserProfileStats() {
        return userProfileRepository.getUserProfileStats().getMappedResults();
    }

    @Transactional
    public UserProfile createUserProfile(UserProfileDTO userProfileDTO) {
        UserProfile userProfile = new UserProfile();
        BeanUtils.copyProperties(userProfileDTO, userProfile);
        userProfileRepository.save(userProfile);
        return userProfile;
    }
}
