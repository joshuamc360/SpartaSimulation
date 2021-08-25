package com.sparta.sdets.controller;

import com.sparta.sdets.view.Displayable;
import com.sparta.sdets.view.Inputable;

public class SimulatorManager {

    Inputable inputManager;
    Displayable displayManager;
    TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
    WaitingListManager waitingListManager;

    int remainingSimulationDuration;
    boolean monthlyOutput;
    //TODO: Take input
        //Duration
        //Output frequency

    remainingSimulationDuration = inputManager.getSimulationDuration();

    //TODO: Main loop
    for(int i = remainingSimulationDuration; i > 0; i --) {

        //Generating trainees
        //Allocating trainees to waiting list
        waitingListManager.generateTrainees();


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

            displayManager.outputAll();

        }
    }

    //TODO: End of simulation - output
    //Number of open centres
    //Number of full centres
    //Number of trainees currently training
    //Number of trainees on waiting list
    //Number of closed centres
    displayManager.outputAll();
}
