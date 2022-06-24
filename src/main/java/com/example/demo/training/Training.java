package com.example.demo.training;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer kilometres;
    @Column(name = "trainingDate")
    private LocalDate trainingDate;
    @Column(name = "kCal")
    private Integer kCal;
    private LocalTime time;
}
