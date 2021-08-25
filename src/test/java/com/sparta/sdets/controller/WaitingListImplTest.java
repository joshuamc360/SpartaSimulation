package com.sparta.sdets.controller;

import com.sparta.sdets.model.Trainee;
import com.sparta.sdets.model.TraineeDTO;
import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.TrainingCentreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WaitingListImplTest {
    WaitingListImpl waitingListImpl = new WaitingListImpl();
    ArrayList<TraineeDTO> waitingList = new ArrayList<>();

    @Test
    public void getAndAddTraineesTest() {
        TraineeDTO nirel = new Trainee();
        waitingListImpl.addToWaitingList(nirel);
        Assertions.assertEquals(nirel, waitingListImpl.getTrainees().get(0));
    }

    @Test
    public void removeFromWaitingListTest() {
        TraineeDTO nirel = new Trainee();
        waitingListImpl.addToWaitingList(nirel);
        waitingListImpl.getTrainees().remove(0);
        Assertions.assertEquals(waitingListImpl.getTrainees().size(), 0);
    }



}





