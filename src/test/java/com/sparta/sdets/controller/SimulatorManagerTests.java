package com.sparta.sdets.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimulatorManagerTests {

    private SimulatorManager simulatorManager;
    private static InputStream input;
    private static Scanner scanner;

    /*@BeforeAll
    static void setup() {
        simulatorManager = new SimulatorManager();
    }*/

    @Test
    public void testExpectedOutputIsReceivedWhenSimulationIsFinished() {
        simulatorManager = new SimulatorManager();

        String string = "1";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();

    }

    @Test
    public void testCentresNotCreatedEveryMonth() {
        simulatorManager = new SimulatorManager();

        String string = "10";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();

        Assertions.assertTrue( 10 > simulatorManager.trainingCentreManager.getAllTrainingCentreDTOS().size());

    }

    @Test
    public void testCentresCreatedEveryTwoMonths() {
        simulatorManager = new SimulatorManager();
        //------------------------------------------------------

        //Staring at 1, should create a new one on
        //3, 5, 7, 9 = 5 centres

        String string = "9";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();

        Assertions.assertEquals(5, simulatorManager.trainingCentreManager.getAllTrainingCentreDTOS().size());
    }


}
