package com.sparta.sdets.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraineeGeneratorClassTest {

    TraineeGeneratorClass traineeGeneratorClass = new TraineeGeneratorClass();

    @Test
    void typicalInput1 () {
        assertEquals(traineeGeneratorClass.generateTrainee(74).size(), 74);
    }
    @Test
    void typicalInput2 () {
        assertEquals(traineeGeneratorClass.generateTrainee(6).size(), 6);
    }
    @Test
    void typicalInput3 () {
        assertEquals(traineeGeneratorClass.generateTrainee(50).size(), 50);
    }

    @Test
    void edgeCase1 () {
        assertEquals(traineeGeneratorClass.generateTrainee(0).size(), 0);
    }
    @Test
    void edgeCase2 () {
        assertEquals(traineeGeneratorClass.generateTrainee(100).size(), 100);
    }
    @Test
    void boundaryCase1 () {
        assertEquals(traineeGeneratorClass.generateTrainee(-1).size(), 0);
    }
    @Test
    void boundaryCase2 () {
        assertEquals(traineeGeneratorClass.generateTrainee(101).size(), 0);
    }

}