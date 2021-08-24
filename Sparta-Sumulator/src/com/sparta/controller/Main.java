package com.sparta.controller;

import com.sparta.controller.model.RandomNumberGenerator;
import com.sparta.controller.model.Trainee;
import com.sparta.controller.model.TraineeGeneratorClass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TraineeGeneratorClass tgc = new TraineeGeneratorClass();
        ArrayList<Trainee> traineesList = tgc.generateTrainee(RandomNumberGenerator.getRandomNumber(0,100));
        System.out.println(traineesList.get(1).getState());
    }

}
