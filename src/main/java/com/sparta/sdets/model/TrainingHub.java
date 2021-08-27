package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingHub extends TrainingCentre {

    private static final int capacity = 200;

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getRemainingSpace() {
        return capacity - super.getTraineesList().size();

    }
}
