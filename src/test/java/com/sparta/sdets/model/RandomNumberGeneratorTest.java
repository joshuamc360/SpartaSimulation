package com.sparta.sdets.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @Test
    void typicalInput1 (){
        int upperbound = 50;
        int lowerBound = 0;

        int randuNum = RandomNumberGenerator.getRandomNumber(lowerBound,upperbound);
        assertTrue(randuNum >=lowerBound && randuNum<=upperbound);
    }

    @Test
    void typicalInput2() {
        int upperbound = 100;
        int lowerBound = 0;

        int randuNum = RandomNumberGenerator.getRandomNumber(lowerBound,upperbound);
        assertTrue(randuNum >=lowerBound && randuNum<=upperbound);
    }

    @Test
    void typicalInput3() {
        int upperbound = 75;
        int lowerBound = 25;

        int randuNum = RandomNumberGenerator.getRandomNumber(lowerBound,upperbound);
        assertTrue(randuNum >=lowerBound && randuNum<=upperbound);
    }

    @Test
    void errorTest1() {
        int upperbound = 1;
        int lowerBound = 20;

        int randuNum = RandomNumberGenerator.getRandomNumber(lowerBound,upperbound);
        assertEquals(0, randuNum);
    }

    @Test
    void boundaryCase1() {
        int upperbound = -1;
        int lowerBound = -100;

        int randomNum = RandomNumberGenerator.getRandomNumber(lowerBound,upperbound);
        assertTrue(randomNum >=lowerBound && randomNum<=upperbound);
    }


}