package com.example.demo.web.controller;

import com.example.demo.training.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class TrainingController {

    private final TrainingService trainingService;
    @GetMapping("/training")
    public String training(Model model){
        model.addAttribute("listTraining", trainingService.getAllTraining());
        return "training";
    }
}
