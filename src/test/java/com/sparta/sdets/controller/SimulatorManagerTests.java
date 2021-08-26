package com.sparta.sdets.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimulatorManagerTests {

    private static SimulatorManager simulatorManager;
    private static InputStream input;
    private static Scanner scanner;

    @BeforeAll
    static void setup() {
        simulatorManager = new SimulatorManager();
        input = new ByteArrayInputStream("10".getBytes());
        scanner = new Scanner(System.in);
    }

    @Test
    public void testExpectedOutputIsRecievedWhenSimulationIsFinished() {

        simulatorManager.run();
    }


}
