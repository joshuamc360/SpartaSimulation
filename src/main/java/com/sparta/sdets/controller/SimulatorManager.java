package com.sparta.sdets.controller;

import com.sparta.sdets.model.*;
import com.sparta.sdets.model.WaitingListImpl;
import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.Displayable;
import com.sparta.sdets.view.InputManager;

import java.util.ArrayList;
import java.util.List;

public class SimulatorManager {

    private Displayable displayManager = new DisplayManager();
     TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
    private TraineeGeneratorClass traineeGenerator = new TraineeGeneratorClass();

    private WaitingListImpl waitingList;

    private boolean monthlyOutput;

    public void run() {

        waitingList = WaitingListImpl.getWaitingListObj();
        int simulationDuration;

        //TODO: Take input
            //Output frequency

        //DisplayManager.askForInput();
        simulationDuration = InputManager.getSimulationDuration();

        displayManager.printGetMonths(simulationDuration);

        //TODO: Main loop
        for(int i = simulationDuration; i > 0; i --) {

            //Generating trainees
            //Allocating trainees to waiting list
            List<Trainee> trainees = traineeGenerator.generateTrainee(RandomNumberGenerator.getRandomNumber(50, 100));
            //System.out.println(trainees.size() + " trainees generated");
            for (Trainee trainee : trainees) {
                this.waitingList.push(trainee);
            }

            //Generating training centres
            if((simulationDuration - i) % 2 == 0) {
                //System.out.println(i + " creating new training centre");
                trainingCentreManager.createCentre();
            }

            //Allocating trainees to available centres
            trainingCentreManager.addTraineesToCentre();

            //TODO: Richard
            //Checking training centres
            //Closing training centres

/*            //TODO: Monthly Output
            displayManager.printSimulationResults(
                    //Closed centres + available centres = all centres
                    trainingCentreManager.getAllTrainingCentreDTOS().size(),
                    trainingCentreManager.getFullCentres().size(),
                    this.waitingList.getTrainees().size(),
                    simulationDuration,
                    inTraining,
                    trainingCentreManager.getAvailableCentres().size()
            );*/

            }

        int inTraining = 0;
        ArrayList<TrainingCentreDTO> centres = trainingCentreManager.getAllTrainingCentreDTOS();
        for (TrainingCentreDTO centreDTO : centres) {
            inTraining += centreDTO.getTraineesList().size();
        }

        displayManager.printSimulationResults(
                //Closed centres + available centres = all centres
                trainingCentreManager.getAllTrainingCentreDTOS().size(),
                trainingCentreManager.getFullCentres().size(),
                this.waitingList.getTrainees().size(),
                simulationDuration,
                inTraining,
                trainingCentreManager.getAvailableCentres().size()
        );

    }
}
