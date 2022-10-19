package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString

public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String libelle;
    @Enumerated(EnumType.STRING)
    ESociety society;

    float debit;
    float credit;
    String Image;
    float Total;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;


    @OneToOne
    Media facturePicture;



    @ManyToOne( fetch = FetchType.LAZY )
    User user ;

}
