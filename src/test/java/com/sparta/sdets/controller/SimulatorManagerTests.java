package com.sparta.sdets.controller;

import com.sparta.sdets.model.Trainee;
import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.TrainingCentreDTO;
import com.sparta.sdets.model.WaitingListImpl;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class SimulatorManagerTests extends SimulatorManager{

    private SimulatorManager simulatorManager;
//    private static Scanner scanner;

    @BeforeEach
    void setup() {
        simulatorManager = new SimulatorManager();
    }
    /*

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

   /* @Test
    @DisplayName("Centre with less than 25 trainees in them should be removed.")
    void removeLowTraineesCentresTest(){
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        ArrayList<Trainee> waitingList = waitingListObj.getTrainees();
        waitingList.removeAll(waitingList);

        TrainingCentre trainingCentre = new TrainingCentre();
        TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();

        for (int i = 0; i < 2; i++){
            Trainee trainee = new Trainee();
            trainingCentre.addToQueue(trainee);
        }

        trainingCentreManager.addCentreToList(trainingCentre);

        super.removeLowTraineesCentres();

        int trainingCentresOpen = trainingCentreManager.getAvailableCentres().size();
        Assertions.assertEquals(0, trainingCentresOpen);
    }*/

}
