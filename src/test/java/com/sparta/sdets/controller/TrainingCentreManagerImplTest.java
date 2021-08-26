package com.sparta.sdets.controller;

import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.TrainingCentreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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