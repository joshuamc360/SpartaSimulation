package com.sparta.controller.model;

import java.util.ArrayList;

public interface WaitingList {
    TraineeDTO pop(ArrayList TraineeList);
    void push(ArrayList TraineeList, TraineeDTO traineeDTO);
}
