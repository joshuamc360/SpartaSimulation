package com.sparta.sdets.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class DisplayManagerTest {


    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void askForInputTest(){
        DisplayManager.askForInput();
        assertEquals("" +
                "How many months would you like to run the simulation for?:", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    void invalidInputTest(){
        DisplayManager.invalidInput();
        assertEquals("Invalid Input. Please provide a valid input between 1 and 1200!", outputStreamCaptor.toString()
                .trim());
    }
    @Test
    void printGetMonthsTest(){
        DisplayManager obj = new DisplayManager();
        obj.printGetMonths(2);
        assertEquals("Running a simulation for " + 2 + " months", outputStreamCaptor.toString()
                .trim());

    }
    @Test
    void printSimulationResultsTest(){

        int  openCenters = 5;
        int fullCentres=2;
        int waitingListSize=3;
        int monthsPassed=4;
        int totalTraining=5;
        int notFullCentres=1;

        StringBuilder expectedRes = new StringBuilder();
        DisplayManager obj = new DisplayManager();
        obj.printSimulationResults(openCenters,fullCentres,waitingListSize,monthsPassed,totalTraining,notFullCentres);

        expectedRes.append("There are "+openCenters+" total open centres");
        expectedRes.append(System.getProperty("line.separator"));
        expectedRes.append("There are: 5 people currently training");
        expectedRes.append(System.getProperty("line.separator"));
        expectedRes.append("There are: 3 people on the waiting list");
        expectedRes.append(System.getProperty("line.separator"));
        expectedRes.append("There are: 2 full centres");
        expectedRes.append(System.getProperty("line.separator"));
        expectedRes.append("There are: 1 centres that are NOT full");
        expectedRes.append(System.getProperty("line.separator"));
        expectedRes.append("After: 4 months");
        assertEquals(expectedRes.toString().trim(), outputStreamCaptor.toString().trim());
    }


}