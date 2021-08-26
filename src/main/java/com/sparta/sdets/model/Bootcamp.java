package com.sparta.sdets.model;

import java.util.ArrayList;

public class Bootcamp extends TrainingCentre {
    private static int bootcampCount = 0;
    private static final int maxBootcamps = 2;
    private ArrayList<Trainee> traineesListInCentre;
    private static final int maxTraineeCapacity = 500;

    public Bootcamp() {
        traineesListInCentre = new ArrayList<Trainee>();
        bootcampCount++;
    }

    public static int getBootcampCount() {
        return bootcampCount;
    }

    public static int getBootcamps() {
        return maxBootcamps;
    }

    @Override
    public int getCapacity() {
        return maxTraineeCapacity - traineesListInCentre.size();
    }

    public int getRemainingPlaces() {
        return getCapacity();
    }

}
