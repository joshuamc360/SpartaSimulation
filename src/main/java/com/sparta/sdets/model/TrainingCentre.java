package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingCentre implements TrainingCentreDTO{
    protected ArrayList<Trainee> traineesListInCentre;
    private final static int CAPACITY = 100;

    public TrainingCentre(){
        traineesListInCentre = new ArrayList<>();
    }

    @Override
    public int getCapacity() {
        return CAPACITY;
    }

    public int getRemainingSpace() {
        return CAPACITY - this.traineesListInCentre.size();
    }

    @Override
    public ArrayList getTraineesList() {
        return this.traineesListInCentre;
    }

    @Override
    public void addToQueue(Trainee trainee) {
        traineesListInCentre.add(trainee);
    }
}
