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
    private TrainingCentreDTO trainingCentreDTO = new TrainingCentre();
    private TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();

    @Test
    public void getAvailabilityTest() {
        Assertions.assertEquals(100,
                trainingCentreManager.getAvailability(trainingCentreDTO));
    }

    @Test
    public void getAvailableCentresTest() {
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

    @Test
    public void addNewCentreTest(){
        int size1 = trainingCentreManager.getAllTrainingCentreDTOS().size();
        trainingCentreManager.addNewCentreToList();
        int size2 = trainingCentreManager.getAllTrainingCentreDTOS().size();
        Assertions.assertEquals(size1 + 1, size2);
    }

    @Test
    @DisplayName("Tests getFullCentres, getAvailableCentres, getAllTrainingCentresDTOS")
    public void getCentresTest(){
        trainingCentreManager.addNewCentreToList();
        int full = trainingCentreManager.getFullCentres().size();
        int available = trainingCentreManager.getAvailableCentres().size();
        int all = trainingCentreManager.getAllTrainingCentreDTOS().size();
        Assertions.assertEquals(all, full + available);
    }

}