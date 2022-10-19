package com.example.demo.Playload;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

    private String Username;


    private String lastName;

    private String email;

    private Set<String> roles;


    private String password;


}
