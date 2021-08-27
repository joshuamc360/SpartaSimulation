package com.sparta.sdets.model;

import java.util.ArrayList;

public abstract class TrainingCentre implements TrainingCentreDTO{

    protected ArrayList<Trainee> traineesListInCentre;

    public TrainingCentre(){
        traineesListInCentre = new ArrayList<>();
    }

    @Override
    public abstract int getCapacity();

    public abstract int getRemainingSpace();

    @Override
    public ArrayList<Trainee> getTraineesList() {
        return this.traineesListInCentre;
    }

    @Override
    public void addToQueue(Trainee trainee) {
        traineesListInCentre.add(trainee);
    }
}
