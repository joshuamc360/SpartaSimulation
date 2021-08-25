package com.sparta.sdets.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TrainingCentreTest {
    @Test
    @DisplayName("Trainee is added to trainee List in centre")
    void traineeAddedToTraineeListInCentre(){
        Trainee trainee = new Trainee();
        TrainingCentre trainingCentre = new TrainingCentre();

        trainingCentre.addToQueue(trainee);

        ArrayList<Trainee> expectedTraineeList = trainingCentre.getQueue();
        Trainee expectedTrainee = expectedTraineeList.get(0);

        Assertions.assertEquals(expectedTrainee, trainee);
    }

    @RepeatedTest(30)
    @DisplayName("Trainees between 0 - 20 should be added to traineesList in centre")
    void traineeListAddedToTraineeListInCentre(){
        TrainingCentre trainingCentre = new TrainingCentre();
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        Trainee trainee = new Trainee();

        for(int i = 0; i < 20; i ++){
            waitingListObj.push(trainee);
        }

        trainingCentre.addTraineesToCentre();

        ArrayList<Trainee> expectedTraineeList = trainingCentre.getQueue();

        System.out.println(expectedTraineeList.size());
        Assertions.assertTrue(expectedTraineeList.size()<=20);
    }
}