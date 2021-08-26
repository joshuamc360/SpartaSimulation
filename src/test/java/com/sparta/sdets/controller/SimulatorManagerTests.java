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

    /*private SimulatorManager simulatorManager;
    private static Scanner scanner;

    *//*@BeforeAll
    static void setup() {
        simulatorManager = new SimulatorManager();
    }*//*

    @Test
    public void testExpectedOutputIsReceivedWhenSimulationIsFinished() {
        simulatorManager = new SimulatorManager();
        InputStream input;
        InputStream input2;

        String string = "n";
        input = new ByteArrayInputStream(string.getBytes());
        System.setIn(input);

        string = "1";
        input2 = new ByteArrayInputStream(string.getBytes());
        System.setIn(input2);

        simulatorManager.run();

*//*        String simulatedUserInput = "input1" + System.getProperty("line.separator")
                + "input2" + System.getProperty("line.separator");

        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));*//*



    }

    @Test
    public void testCentresNotCreatedEveryMonth() {
        simulatorManager = new SimulatorManager();
        InputStream input;

        String string = "10\nn";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();

        Assertions.assertTrue( 10 > simulatorManager.trainingCentreManager.getAllTrainingCentreDTOS().size());

    }

    @Test
    public void testCentresCreatedEveryTwoMonths() {
        simulatorManager = new SimulatorManager();
        //------------------------------------------------------
        InputStream input;
        //Staring at 1, should create a new one on
        //3, 5, 7, 9 = 5 centres

        String string = "9\nn";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();

        Assertions.assertEquals(5, simulatorManager.trainingCentreManager.getAllTrainingCentreDTOS().size());
    }

    @Test
    public void testSingleOutput() {
        InputStream input;
        simulatorManager = new SimulatorManager();
        String string = "9\nn";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();
    }

    @Test
    public void testMonthlyOutput() {
        InputStream input;
        simulatorManager = new SimulatorManager();
        String string = "9\ny";
        input = new ByteArrayInputStream(string.getBytes());

        System.setIn(input);
        simulatorManager.run();
    }*/


}
