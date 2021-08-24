package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingCentre implements TrainingCentreDTO{
    @Override
    public int getCapacity() {
        return 0;
    }

    @Override
    public ArrayList getQueue() {
        return null;
    }

    @Override
    public void addToQueue(TraineeDTO traineeDTO) {

    }
}
