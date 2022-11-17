package com.app;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("/userProfile/all")
    public List<UserProfileDTO> getAllUserProfiles() {
        List<UserProfile> userProfiles = userProfileService.getAllUSerProfiles();
        return userProfiles.stream().map(u -> {
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            BeanUtils.copyProperties(u, userProfileDTO);
            return userProfileDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/userProfile")
    public List<UserProfileDTO> getUserProfilesByFilter(@RequestParam("state") String state,
                                                        @RequestParam("city") String city) {
        List<UserProfile> userProfiles = userProfileService.getUserProfiles(state, city);
        return userProfiles.stream().map(u -> {
            UserProfileDTO userProfileDTO = new UserProfileDTO();
            BeanUtils.copyProperties(u, userProfileDTO);
            return userProfileDTO;
        }).collect(Collectors.toList());
    }

    @GetMapping("/userProfile/stats")
    public List<UserProfileStat> getUserProfilesStats() {
        return userProfileService.getUserProfileStats();
    }

    @PostMapping("/userProfile")
    public UserProfileDTO createUserProfile(@RequestBody UserProfileDTO userProfileDTO) {
        UserProfile userProfile = userProfileService.createUserProfile(userProfileDTO);
        BeanUtils.copyProperties(userProfile, userProfileDTO);
        return userProfileDTO;
    }
}
