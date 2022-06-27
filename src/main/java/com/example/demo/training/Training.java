package com.example.demo.training;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@NoArgsConstructor

public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer kilometres;
    @Column(name = "trainingDate")
    private Date trainingDate;
    @Column(name = "kCal")
    private Integer kCal;
    private Time time;
    private String noteText;

    public Training(Integer kilometres, Date trainingDate, Integer kCal, Time time, String noteText) {
        this.kilometres = kilometres;
        this.trainingDate = trainingDate;
        this.kCal = kCal;
        this.time = time;
        this.noteText = noteText;
    }
}
