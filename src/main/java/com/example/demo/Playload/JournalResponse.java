package com.example.demo.Playload;

import com.example.demo.entities.ESociety;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class JournalResponse {



    Long id;


    String libelle;
    @Enumerated(EnumType.STRING)
    ESociety society;

    float debit;
    float credit;
    //String Image;
    float Total;

    LocalDateTime createdAt;

   // LocalDateTime updatedAt;








}
