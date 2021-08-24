package com.sparta.controller.controller;

import com.sparta.controller.model.TraineeDTO;

import java.util.ArrayList;

public interface WaitingListManager {
    ArrayList getTrainees();
    void addToWaitingList(TraineeDTO traineeDTO);
    TraineeDTO removeFromWaitingList();
}
