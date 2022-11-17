package com.gaman;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirsBaseController {

    @Autowired
    private FirebaseApp firebaseApp;

    @GetMapping("/public/test")
    public String publicMethod() {
        return "public endpoint";
    }

    @GetMapping("/currentUser")
    public Object getCurrentLoggedInUser(@RequestParam("userId") String userId) throws FirebaseAuthException {
        return FirebaseAuth.getInstance(firebaseApp).getUser(userId);
    }
}
