package com.sparta.sdets.controller;

import com.sparta.sdets.model.Trainee;
import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.TrainingCentreDTO;
import com.sparta.sdets.model.WaitingListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TrainingCentreManagerImplTest {

    @Test
    public void getAvailabilityTest() {
        TrainingCentreDTO trainingCentreDTO = new TrainingCentre();
        TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
        Assertions.assertEquals(100,
                trainingCentreManager.getAvailability(trainingCentreDTO));
    }

    @Test
    public void getAvailableCentresTest() {
        TrainingCentreDTO trainingCentreDTO = new TrainingCentre();
        TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
        trainingCentreManager.addCentreToList(trainingCentreDTO);
        Assertions.assertEquals(trainingCentreDTO,
                trainingCentreManager.getAvailableCentres().get(0));
    }

    @RepeatedTest(30)
    @DisplayName("Trainees between 0 - 20 should be added to traineesList in centre")
    void traineeListAddedToTraineeListInCentre(){
        TrainingCentreManagerImpl trainingCentreManagerImpl = new TrainingCentreManagerImpl();
        TrainingCentre trainingCentre = new TrainingCentre();
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        Trainee trainee = new Trainee();

        for(int i = 0; i < 20; i ++){
            waitingListObj.push(trainee);
        }

        trainingCentreManagerImpl.addCentreToList(trainingCentre);
        trainingCentreManagerImpl.addTraineesToCentre();

        ArrayList<Trainee> expectedTraineeList = trainingCentre.getTraineesList();

        System.out.println(expectedTraineeList.size());
        Assertions.assertTrue(expectedTraineeList.size()<=20);
    }
}