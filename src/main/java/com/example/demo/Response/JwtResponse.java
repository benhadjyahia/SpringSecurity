package com.example.demo.Response;

import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Data

public class JwtResponse {
    @NonNull
    private String token;
    @NonNull
    private String type;
    @NonNull
    private String message;


}

