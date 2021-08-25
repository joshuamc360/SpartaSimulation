package com.sparta.sdets.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WaitingListImplTest {
    @Test
    @DisplayName("Pop waiting List returns a trainee")
    void popReturnsTrainee(){
        ArrayList<Trainee> traineeList = new ArrayList<>();
        traineeList.add(new Trainee());

        Trainee trainee = WaitingListImpl.pop(traineeList);
        Assertions.assertEquals("Created", trainee.getState());
    }

    @Test
    @DisplayName("20 trainees should be added to the waiting list")
    void traineesAddedToWaitingList(){
        Trainee trainee = new Trainee();
        WaitingListImpl waitingListObject = WaitingListImpl.getWaitingList();
        ArrayList<Trainee> waitingList = waitingListObject.getTrainees();
        for(int i = 0; i < 20; i ++){
            WaitingListImpl.push(trainee);
        }

        int actualTraineesInWaitingListSize = 20;

        Assertions.assertEquals(actualTraineesInWaitingListSize, waitingList.size());
    }
}
