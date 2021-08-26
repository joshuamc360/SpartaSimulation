package com.sparta.sdets.model;

public class RandomNumberGenerator {
    public static int getRandomNumber(int lowerBound, int upperBound) {
        if(upperBound<lowerBound){
            return 0;
        }else {
            return (int) Math.floor(Math.random() * (upperBound - lowerBound + 1) + lowerBound);
        }
    }
}
