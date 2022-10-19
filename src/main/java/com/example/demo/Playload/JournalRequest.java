package com.example.demo.Playload;

import com.example.demo.entities.ESociety;
import com.example.demo.entities.Media;
import com.example.demo.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
public class JournalRequest {



    String libelle;
    @Enumerated(EnumType.STRING)
    ESociety society;

    float debit;
    float credit;


    Media profilPicture;


}
