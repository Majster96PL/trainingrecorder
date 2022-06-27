package com.example.demo.training;

import com.example.demo.exceprion.TrainingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;
    public List<Training> getAllTraining() {
        return trainingRepository.findAll();
    }

    public Training saveTraining(Training training){
        return trainingRepository.save(training);
    }

    public Training updateTraining(Long id){
        Optional<Training> optionalTraining = trainingRepository.findById(id);
        Training training = null;
        if(optionalTraining.isPresent()){
            training = optionalTraining.get();
        }else{
            throw new TrainingException("Training not found!");
        }
        return trainingRepository.save(training);
    }

    public void deleteTraining(Long id){
        trainingRepository.deleteById(id);
    }


}
