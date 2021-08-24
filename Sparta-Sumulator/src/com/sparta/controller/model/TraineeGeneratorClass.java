package com.sparta.controller.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TraineeGeneratorClass implements TraineeGenerator {

    @Override
    public ArrayList<Trainee> generateTrainee(int numOfTraineeToGenerate) {
        ArrayList<Trainee> traineesList = new ArrayList<>();
        for(int i = 0; i < numOfTraineeToGenerate ; i++) {
            traineesList.add(new Trainee());
        }
        return traineesList;
    }
}
