package com.sparta.sdets.model;

import java.util.ArrayList;

public class Bootcamp extends TrainingCentre {
    private static int bootcampCount = 0;
    private static final int maxBootcamps = 2;
    private ArrayList<Trainee> bootcampArrayList;
    private static final int maxTraineeCapacity = 500;

    public Bootcamp() {
        bootcampArrayList = new ArrayList<Trainee>();
        bootcampCount++;
    }

    public ArrayList<Trainee> getBootcamps() {
        return bootcampArrayList;
    }

    public void addToBootcamps(Trainee trainee) {
        bootcampArrayList.add(trainee);
    }

    public Trainee removeFromBootcamp() {
        if(bootcampArrayList.get(0) != null) {
            Trainee removedTrainee = bootcampArrayList.get(0);
            bootcampArrayList.remove(0);
            return removedTrainee;
        }
        return null;
    }

    public int getBootcampCount() {
        return bootcampCount;
    }

    public int getBootcampLimit() {
        return maxBootcamps;
    }

    @Override
    public int getCapacity() {
        return maxTraineeCapacity;
    }

    public int getRemainingPlaces() {
        return maxTraineeCapacity - bootcampArrayList.size();
    }

}
