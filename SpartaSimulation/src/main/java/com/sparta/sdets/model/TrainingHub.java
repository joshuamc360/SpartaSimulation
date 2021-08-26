package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingHub extends TrainingCentre{

    private static int totalTrainingHubs = 0;
    private final static int maxTraineeCapacity = 200;
    private ArrayList<Trainee> traineesListInCentre;

    public TrainingHub() {
        totalTrainingHubs++;
        traineesListInCentre = new ArrayList<>();
    }

    @Override
    public ArrayList<Trainee> getTraineesList() {
        return this.traineesListInCentre;
    }

    public void addToTrainingHub(Trainee trainee) {
        traineesListInCentre.add(trainee);
    }

    public Trainee removeFromTrainingHub() {
        if (!traineesListInCentre.isEmpty()) {
            Trainee removedTrainee = (traineesListInCentre.get(0));
            traineesListInCentre.remove(0);
            return removedTrainee;
        } else {
            return null;
        }
    }

    @Override
    public int getCapacity() {
        return maxTraineeCapacity;
    }

    public static int getTotalTrainingHubs() {
        return totalTrainingHubs;
    }

    public int getTraineeListSize() {
        return traineesListInCentre.size();
    }

    public int getRemainingPlaces() {
        return maxTraineeCapacity - traineesListInCentre.size();
    }
}
