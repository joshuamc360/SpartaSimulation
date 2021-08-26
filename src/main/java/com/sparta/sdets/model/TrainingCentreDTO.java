package com.sparta.sdets.model;
import java.util.ArrayList;

public interface TrainingCentreDTO {
    int getCapacity();
    int getRemainingSpace();
    ArrayList getTraineesList();
    void addToQueue(Trainee trainee);
}
