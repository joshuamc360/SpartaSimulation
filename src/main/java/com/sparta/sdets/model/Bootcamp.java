package com.sparta.sdets.model;

import java.util.ArrayList;

public class Bootcamp extends TrainingCentre {
    private static int bootcampCount = 0;
    private static final int maxBootcamps = 2;

    private static final int maxTraineeCapacity = 500;

    private int numMonthsUnder25;

    public Bootcamp() {
        super();
        bootcampCount++;
        numMonthsUnder25 = 0;
    }

    public static int getBootcampCount() {
        return bootcampCount;
    }

    public static int getBootcampLimit() {
        return maxBootcamps;
    }

    public int getNumMonthsUnderTwentyFiveCounter() {
        return this.numMonthsUnder25;
    }

    public Trainee removeFromBootcamp() {
        if(super.getTraineesList().get(0) != null) {
            Trainee removedTrainee = super.getTraineesList().get(0);
            super.getTraineesList().remove(0);
            return removedTrainee;
        }
        return null;
    }

    @Override
    public int getCapacity() {
        return maxTraineeCapacity;
    }

    @Override
    public int getRemainingSpace() {
        return maxTraineeCapacity - super.getTraineesList().size();
    }

    public void incrementMonthsUnderTwentyFive() {
        this.numMonthsUnder25 ++;
    }
    public void resetMonthsUnderTwentyFiveCounter() {
        this.numMonthsUnder25 = 0;
    }

}
