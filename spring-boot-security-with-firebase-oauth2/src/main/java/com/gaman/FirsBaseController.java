package com.gaman;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class FirsBaseController {

    @Autowired
    private FirebaseApp firebaseApp;

    @GetMapping("/public/test")
    public String publicMethod() {
        return "public endpoint";
    }

    @PostMapping("/firebase/user")
    public FirebaseUserDTO createUser(@RequestBody FirebaseUserDTO firebaseUserDTO) throws FirebaseAuthException {
        UserRecord.CreateRequest createRequest = new UserRecord.CreateRequest();
        createRequest.setEmail(firebaseUserDTO.getEmail());
        createRequest.setPassword(firebaseUserDTO.getPassword());
        FirebaseAuth.getInstance(firebaseApp).createUser(createRequest);
        return firebaseUserDTO;
    }

    @GetMapping("/currentUser")
    public Object getCurrentLoggedInUser(@RequestParam("userId") String userId) throws FirebaseAuthException {
        Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        jwt.getClaims().forEach((k, v) -> {
            log.info(" key : {} ,value  : {}", k, v);
        });
        jwt.getHeaders().forEach((k, v) -> {
            log.info(" key : {} ,value  : {}", k, v);
        });
        jwt.getAudience().forEach(k -> {
            log.info(" key : {} ", k);
        });
        return FirebaseAuth.getInstance(firebaseApp).getUser(userId);
    }
}
