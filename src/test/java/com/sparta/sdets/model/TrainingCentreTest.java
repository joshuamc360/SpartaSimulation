package com.sparta.sdets.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class TrainingCentreTest {
    @Test
    @DisplayName("Trainee is added to trainee List in centre")
    void traineeAddedToTraineeListInCentre(){
        Trainee trainee = new Trainee();
        TrainingCentre trainingCentre = new TrainingCentre();

        trainingCentre.addToQueue(trainee);

        ArrayList<Trainee> expectedTraineeList = trainingCentre.getTraineesList();
        Trainee expectedTrainee = expectedTraineeList.get(0);

        Assertions.assertEquals(expectedTrainee, trainee);
    }

    @Test
    @DisplayName("Remaining centre should return 80.")
    void traineeAddedToCentreReturns80RemainingSpace(){
        Trainee trainee = new Trainee();
        TrainingCentre trainingCentre = new TrainingCentre();
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        ArrayList<Trainee> traineeArrayList = trainingCentre.getTraineesList();

        for(int i = 0; i < 20; i ++){
            waitingListObj.push(trainee);
            traineeArrayList.add(trainee);
        }

        int expectedRemainingSpace = 80;
        int actualRemainingSpace = trainingCentre.getRemainingSpace();

        Assertions.assertEquals(expectedRemainingSpace, actualRemainingSpace);
    }

    @Test
    @DisplayName("Centre capacity should always be 100.")
    void centreCapacityShouldBe100(){
        TrainingCentre trainingCentre = new TrainingCentre();
        int capacity = trainingCentre.getCapacity();
        Assertions.assertEquals(100,capacity);
    }
}