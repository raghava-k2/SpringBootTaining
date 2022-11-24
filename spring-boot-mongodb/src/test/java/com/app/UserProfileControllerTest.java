package com.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(PowerMockRunner.class)
@SpringBootTest
@PowerMockRunnerDelegate(SpringRunner.class)
public class UserProfileControllerTest {

    @InjectMocks
    UserProfileController userProfileController;

    @Mock
    private UserProfileService userProfileService;

    @Test
    public void given_user_calling_when_send_request_then_getAllUsersProfiles() {
        List<UserProfile> list = new ArrayList<>();
        list.add(new UserProfile("1", "asd", "asd", new Date(), "asda", "adsad"));
        Mockito.when(userProfileService.getAllUSerProfiles()).thenReturn(list);
        List<UserProfileDTO> userProfileList = userProfileController.getAllUserProfiles();
        Assertions.assertEquals(userProfileList.size(), 1);
    }

    @Test
    public void given_state_and_city_then_return_empty_filtered_userProfiles() {
        List<UserProfile> list = new ArrayList<>();
        Mockito.when(userProfileService.getUserProfiles("vizag", "hyd")).thenReturn(list);
        List<UserProfileDTO> userProfileList = userProfileController.getUserProfilesByFilter("vizag", "hyd");
        Assertions.assertEquals(userProfileList.size(), 0);
    }

    @Test
    public void given_state_and_city_then_return_filtered_userProfiles() {
        List<UserProfile> list = new ArrayList<>();
        list.add(new UserProfile("1", "asd", "asd", new Date(), "asda", "adsad"));
        Mockito.when(userProfileService.getUserProfiles("vizag", "hyd")).thenReturn(list);
        List<UserProfileDTO> userProfileList = userProfileController.getUserProfilesByFilter("vizag", "hyd");
        Assertions.assertEquals(userProfileList.size(), 1);
    }
}
