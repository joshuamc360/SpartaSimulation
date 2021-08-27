package com.sparta.sdets.util;

import com.sparta.sdets.view.DisplayManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayManagerTest {

        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        void askForInputTest() {
            DisplayManager.askForInput();
            assertEquals("" + "How many months would you like to run the simulation for?:", outputStreamCaptor.toString().trim());
        }

        @Test
        void invalidInputTest() {
            DisplayManager.invalidInput();
            assertEquals("Invalid Input. Please provide a valid input between 1 and 1200!", outputStreamCaptor.toString().trim());
        }

        @Test
        void printGetMonthsTest() {
            DisplayManager obj = new DisplayManager();
            obj.printGetMonths(2);
            assertEquals("Running a simulation for " + 2 + " months", outputStreamCaptor.toString().trim());
        }

        @Test
        void printSimulationResultsTest() {
            int openCenters = 5;
            int fullBootCamps = 0;
            int fullTrainingHubs = 0;
            int waitingListSize = 3;
            int monthsPassed = 4;
            int totalTraining = 5;
            int notFullBootCamps = 1;
            int notFullTrainingHubs = 1;
            int numBootCampsRemoved = 0;
            int numTrainingHubsRemoved = 2;

            StringBuilder expectedRes = new StringBuilder();
            DisplayManager obj = new DisplayManager();
            obj.printSimulationResults(openCenters, fullBootCamps, fullTrainingHubs, waitingListSize, monthsPassed, totalTraining, notFullBootCamps, notFullTrainingHubs, numBootCampsRemoved, numTrainingHubsRemoved);
            expectedRes.append("After: 4 months");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are " + openCenters + " total open centres");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are: " + fullBootCamps + " full boot camps");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are: " + fullTrainingHubs + " full training hubs");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are: " + totalTraining + " people currently training");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are: " + waitingListSize + " people on the waiting list");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are: " + notFullBootCamps + " boot camps that are NOT full");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are: " + notFullTrainingHubs + " training hubs that are NOT full");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are " + numBootCampsRemoved + " boot camps removed");
            expectedRes.append(System.getProperty("line.separator"));
            expectedRes.append("There are " + numTrainingHubsRemoved + " training hubs removed");

            assertEquals(expectedRes.toString().trim(), outputStreamCaptor.toString().trim());
        }
}


