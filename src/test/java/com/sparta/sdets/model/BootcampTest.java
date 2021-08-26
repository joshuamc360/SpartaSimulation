package com.sparta.sdets.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BootcampTest {

    @Test
    @DisplayName("Add a trainee to a bootcamp successfully")
    void addToBootcampsTest() {
        Bootcamp bootcamp = new Bootcamp();
        Trainee trainee = new Trainee();
        bootcamp.addToBootcamps(trainee);
        Assertions.assertEquals(499, bootcamp.getRemainingPlaces());
    }

    @Test
    @DisplayName("Get current bootcamps")
    void getBootcampsTest() {

    }

    @Test
    @DisplayName("Get number of Bootcamps")
    void getBootcampCountTest() {
        Bootcamp bootcamp = new Bootcamp();
        Bootcamp bootcamp2 = new Bootcamp();
        Assertions.assertEquals(2, bootcamp.getBootcampCount());
    }

    @Test
    @DisplayName("Get the Limit of Bootcamps")
    void getBootcampLimitTest() {
        Bootcamp bootcamp = new Bootcamp();
        Assertions.assertEquals(2, bootcamp.getBootcampLimit());
    }

    @Test
    @DisplayName("Get total capacity for Bootcamps")
    void getCapacityTest() {
        Bootcamp bootcamp = new Bootcamp();
        Assertions.assertEquals(500, bootcamp.getCapacity());
    }

    @Test
    @DisplayName("Get remaining places inside a bootcamp")
    void getRemainingPlacesTest() {
        Bootcamp bootcamp = new Bootcamp();
        Trainee trainee = new Trainee();
        bootcamp.addToBootcamps(trainee);
        bootcamp.addToBootcamps(trainee);
        bootcamp.addToBootcamps(trainee);
        Assertions.assertEquals(497, bootcamp.getRemainingPlaces());
    }

    @Test
    @DisplayName("Remove a trainee from a bootcamp successfully")
    void removeFromBootcampTest() {
        Bootcamp bootcamp = new Bootcamp();
        Trainee trainee = new Trainee();
        bootcamp.addToBootcamps(trainee);
        bootcamp.addToBootcamps(trainee);
        bootcamp.removeFromBootcamp();
        Assertions.assertEquals(6,bootcamp.getBootcampCount()); // Expected 6 following the addition of 7 trainees and one being removed
    }
}
