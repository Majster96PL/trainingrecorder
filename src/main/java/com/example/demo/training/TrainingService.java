package com.example.demo.training;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;
    public List<Training> getAllTraining() {
        return trainingRepository.findAll();
    }


}
