package com.sparta.sdets.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WaitingListImplTest {
    @Test
    @DisplayName("Pop waiting List returns a trainee")
    void popReturnsTrainee(){
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        waitingListObj.push(new Trainee());

        Trainee trainee = waitingListObj.pop();
        Assertions.assertEquals("Created", trainee.getState());
    }

    @Test
    public void testPoppingAnEmptyListDoesntWork() {
        WaitingListImpl waitingList = WaitingListImpl.getWaitingListObj();

        Assertions.assertNull(waitingList.pop());

    }

    @Test
    @DisplayName("Pop should remove the returned trainee from the list")
    void popRemovesTrainee(){
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        ArrayList<Trainee> waitingList = waitingListObj.getTrainees();
        waitingList.removeAll(waitingList);
        waitingListObj.push(new Trainee());

        Trainee trainee = waitingListObj.pop();
        Assertions.assertTrue(waitingListObj.getTrainees().size()==0);
    }

    @Test
    @DisplayName("20 trainees should be pushed to the waiting list. Test for push method")
    void traineesAddedToWaitingList(){
        Trainee trainee = new Trainee();
        WaitingListImpl waitingListObject = WaitingListImpl.getWaitingListObj();
        ArrayList<Trainee> waitingList = waitingListObject.getTrainees();
        waitingList.removeAll(waitingList);

        for(int i = 0; i < 20; i ++){
            waitingListObject.push(trainee);
        }

        int actualTraineesInWaitingListSize = 20;

        Assertions.assertEquals(actualTraineesInWaitingListSize, waitingList.size());
    }
}
