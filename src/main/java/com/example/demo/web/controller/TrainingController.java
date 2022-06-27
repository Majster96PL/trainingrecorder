package com.example.demo.web.controller;

import com.example.demo.training.Training;
import com.example.demo.training.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    @GetMapping("/training")
    public String training(Model model){
        model.addAttribute("listTraining", trainingService.getAllTraining());
        return "training";
    }

    @GetMapping("/new")
    public String addNewTraining(Model model){
        Training training = new Training();
        model.addAttribute("training", training );
        return "new";
    }

    @PostMapping("/save")
    public String saveTraining(@ModelAttribute("training") Training training){
        trainingService.saveTraining(training);
        return "redirect:/training";
    }

    @GetMapping("/update/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Long id, Model model) {
        Training training = trainingService.updateTraining(id);
        model.addAttribute("employee", training);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteTraining(@PathVariable(value ="id")Long id){
        trainingService.deleteTraining(id);
        return "redirect:/training";
    }
}
