package com.sparta.sdets.model;
import java.util.ArrayList;

public interface TrainingCentreDTO {
    int getCapacity();
    ArrayList getQueue();
    void addToQueue(TraineeDTO traineeDTO);
}
