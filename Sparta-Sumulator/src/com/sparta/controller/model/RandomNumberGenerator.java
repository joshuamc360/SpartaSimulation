package com.sparta.controller.model;

import java.util.Random;

public class RandomNumberGenerator {
    public static int getRandomNumber(int lowerBound, int upperBound) {
        return (int)Math.floor(Math.random()*(upperBound-lowerBound+1)+lowerBound);
    }
}
