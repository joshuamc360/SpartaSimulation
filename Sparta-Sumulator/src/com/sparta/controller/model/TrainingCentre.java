package com.sparta.controller.model;

import java.util.ArrayList;

public interface TrainingCentre {
    int getCapacity();
    ArrayList getQueue();
    void addToQueue(TraineeDTO traineeDTO);
}
