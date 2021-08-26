package com.sparta.sdets.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrainingHubTest {

    @Test
    void addTraineeTest() {
        TrainingHub trainingHub = new TrainingHub();
        Trainee trainee = new Trainee();
        trainingHub.addToTrainingHub(trainee);
        Assertions.assertEquals(1, trainingHub.getTraineeListSize());
    }

    @Test
    void removeTraineeTest() {
        TrainingHub trainingHub = new TrainingHub();
        Trainee trainee = new Trainee();
        trainingHub.addToTrainingHub(trainee);

        trainingHub.removeFromTrainingHub();
        Assertions.assertEquals(0, trainingHub.getTraineeListSize());
    }

    @Test
    void capacityTest() {
        TrainingHub trainingHub = new TrainingHub();
        Assertions.assertEquals(200, trainingHub.getCapacity());
    }

    @Test
    void getRemainingPlaces() {
        TrainingHub trainingHub = new TrainingHub();
        Trainee trainee = new Trainee();
        trainingHub.addToTrainingHub(trainee);

        Assertions.assertEquals(199, trainingHub.getRemainingPlaces());
    }

    @Test
    void getTraineeListTest() {
        TrainingHub trainingHub = new TrainingHub();
        Trainee trainee = new Trainee();
        trainingHub.addToTrainingHub(trainee);

        Assertions.assertEquals(trainee, trainingHub.getTraineesList().get(0));
    }

    //One training centre for every test case
    @Test
    void getTotalTrainingHubsTest() {
        TrainingHub trainingHub = new TrainingHub();
        Assertions.assertEquals(6, TrainingHub.getTotalTrainingHubs());
    }
}
