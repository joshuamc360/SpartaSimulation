package com.sparta.sdets.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TraineeTest {
    Trainee trainee = new Trainee();

    @Test
    void createdState() {
        assertEquals("Created",trainee.getState());
    }

    @Test
    void WaitingState() {
        trainee.setWaiting();
        assertEquals("Waiting",trainee.getState());
    }

    @Test
    void acceptedState() {
        trainee.setAccepted();
        assertEquals("Accepted",trainee.getState());
    }
}