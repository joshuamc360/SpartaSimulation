package com.sparta.sdets.controller;

import com.sparta.sdets.model.TraineeDTO;
import java.util.ArrayList;

public interface WaitingListManager {
    ArrayList getTrainees();
    void addToWaitingList(TraineeDTO traineeDTO);
    TraineeDTO removeFromWaitingList();
}
