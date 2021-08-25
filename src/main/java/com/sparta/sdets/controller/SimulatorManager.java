package com.sparta.sdets.controller;

import com.sparta.sdets.model.Trainee;
import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.Displayable;
import com.sparta.sdets.view.Inputable;

import java.util.List;

public class SimulatorManager {

    Inputable inputManager;
    Displayable displayManager = new DisplayManager();
    TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
    WaitingListManager waitingListManager;

    int simulationDuration;
    int remainingSimulationDuration;
    boolean monthlyOutput;
    //TODO: Take input
        //Duration
        //Output frequency

    simulationDuration = inputManager.getSimulationDuration();
    monthlyOutput = inputManager.isMonthlyOutput();

    remainingSimulationDuration = simulationDuration;

    displayManager.printGetMonths(simulationDuration);

    //TODO: Main loop
    for(int i = remainingSimulationDuration; i > 0; i --) {

        //Generating trainees
        //Allocating trainees to waiting list
        List<Trainee> trainees = waitingListManager.generateTrainees();
        for (Trainee trainee : trainees) {
            waitingListManager.addToWaitingList(trainee);
        }

        //Generating training centres

        if(2 months passed) {
            trainingCentreManager.createCentre();
        }

        //Allocating trainees to available centres
        trainingCentreManager.allocateTrainees(waitingListManager.getList());

        //Richard
        //Checking training centres
        //Closing training centres


        if(monthlyOutput) {
            //TODO: End of month - output
            //Number of open centres
            //Number of full centres
            //Number of trainees currently training
            //Number of trainees on waiting list
            //Number of closed centres

            displayManager.printSimulationResults(
                    trainingCentreManager.getFullCentres().size(),
                    waitingListManager.getTrainees().size(),
                    simulationDuration,
                    trainingCentreManager.getAllTrainingCentreDTOs.size(),
                    trainingCentreManager.getAvailableCentres().size()
            );

        }
    }

    //TODO: End of simulation - output
    //Number of open centres
    //Number of full centres
    //Number of trainees currently training
    //Number of trainees on waiting list
    //Number of closed centres
    displayManager.printSimulationResults(
        trainingCentreManager.getFullCentres(),
        waitingListManager.getTrainees().size(),
        simulationDuration,
        trainingCentreManager.getAllTraining.size(),
        trainingCentreManager.getAvailableCentres()
    );
}
