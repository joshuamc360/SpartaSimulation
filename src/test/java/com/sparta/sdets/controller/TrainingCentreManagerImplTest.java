package com.sparta.sdets.controller;

import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.TrainingCentreDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}