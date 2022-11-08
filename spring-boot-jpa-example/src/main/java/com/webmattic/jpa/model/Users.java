package com.webmattic.jpa.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Users {

    @Id
    @Column(name = "userid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, name = "ROLE")
    private String role;

    @Column(nullable = false, name = "clientid")
    private Integer clientId;

    @Column(nullable = false, name = "isfirsttimeloggedin")
    private Boolean isFirstTimeLoggedIn;

    @Column(nullable = false, name = "passwordexpiry")
    private Date passwordExpiry;

    @Column(nullable = false, name = "lastloggedin")
    private Date lastLoggedIn;

    @Column(nullable = false, name = "createdon")
    private Date createdOn;

    @Column(nullable = false, name = "updatedon")
    private Date updatedOn;
}
