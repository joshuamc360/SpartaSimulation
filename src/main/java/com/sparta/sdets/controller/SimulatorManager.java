package com.sparta.sdets.controller;

import com.sparta.sdets.model.RandomNumberGenerator;
import com.sparta.sdets.model.Trainee;
import com.sparta.sdets.model.TraineeGeneratorClass;
import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.WaitingListImpl;
import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.Displayable;
import com.sparta.sdets.view.InputManager;
import com.sparta.sdets.view.Inputable;

import java.util.ArrayList;
import java.util.List;

public class SimulatorManager {

    Displayable displayManager = new DisplayManager();
    TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
    TraineeGeneratorClass traineeGenerator = new TraineeGeneratorClass();

    WaitingListImpl waitingList = new WaitingListImpl();

    public void run() {

        int simulationDuration;

        //TODO: Take input
            //Output frequency

        DisplayManager.askForInput();
        simulationDuration = InputManager.getSimulationDuration();

        displayManager.printGetMonths(simulationDuration);

        //TODO: Main loop
        for(int i = simulationDuration; i > 0; i --) {

            //Generating trainees
            //Allocating trainees to waiting list
            List<Trainee> trainees = traineeGenerator.generateTrainee(RandomNumberGenerator.getRandomNumber(50, 100));
            for (Trainee trainee : trainees) {
                this.waitingList.push(trainee);
            }

            //Generating training centres
            if((simulationDuration - i) % 2 == 0) {
                trainingCentreManager.createCentre();
            }

            //Allocating trainees to available centres
            ArrayList<TrainingCentre> centres = trainingCentreManager.getAvailableCentres();
            for(TrainingCentre centre : centres) {
                centre.addTraineesToCentre();
            }

            //TODO: Richard
            //Checking training centres
            //Closing training centres

            //TODO: Monthly Output

/*                displayManager.printSimulationResults(
                        //Closed centres + available centres = all centres
                        (trainingCentreManager.getAvailableCentres().size()
                                + trainingCentreManager.getFullCentres().size()),
                        trainingCentreManager.getFullCentres().size(),
                        this.waitingList.getTrainees().size(),
                        i,
                        trainingCentreManager.getAllTrainingCentreDTOS().size(),
                        trainingCentreManager.getAvailableCentres().size()
                );*/

            }

        displayManager.printSimulationResults(
                //Closed centres + available centres = all centres
                (trainingCentreManager.getAvailableCentres().size()
                        + trainingCentreManager.getFullCentres().size()),
                trainingCentreManager.getFullCentres().size(),
                this.waitingList.getTrainees().size(),
                simulationDuration,
                trainingCentreManager.getAllTrainingCentreDTOS().size(),
                trainingCentreManager.getAvailableCentres().size()
        );

    }
}
