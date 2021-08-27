package com.sparta.sdets.controller;

import com.sparta.sdets.model.*;
import com.sparta.sdets.model.WaitingListImpl;
import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.Displayable;
import com.sparta.sdets.view.InputManager;

import java.util.ArrayList;
import java.util.List;

public class SimulatorManager {

    private DisplayManager displayManager = new DisplayManager();
     TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();
    private TraineeGeneratorClass traineeGenerator = new TraineeGeneratorClass();
    private static int centresRemoved = 0;
    private static int bootCampsRemoved = 0;
    private static int trainingCentresRemoved = 0;

    private WaitingListImpl waitingList;

    private boolean monthlyOutput;

    public void run() {

        waitingList = WaitingListImpl.getWaitingListObj();
        int simulationDuration;
        boolean monthlyOutput = false;

        //TODO: Take input
            //Output frequency

        //DisplayManager.askForInput();

        do {
            simulationDuration = InputManager.getSimulationDuration();
        } while(simulationDuration == -1);

        monthlyOutput = InputManager.isMonthlyOutputWanted();

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
                //If max number of boot
                String centreType;
                if(Bootcamp.getBootcampCount() >= Bootcamp.getBootcampLimit()) {
                    centreType = RandomNumberGenerator.getTrainingCentreType(2, 2);
                } else {
                    centreType = RandomNumberGenerator.getTrainingCentreType(1, 2);
                }
                trainingCentreManager.createCentre(centreType);
            }

            //Allocating trainees to available centres
            trainingCentreManager.addTraineesToCentre();

            //TODO: Richard
            //Checking training centres
            //Closing training centres

            //Start removing centres 3 months in
            if(i <= simulationDuration - 2) {
                removeLowTraineesCentres();
            }

            //TODO: Monthly Output
            //Don't do a monthly output on the last month - handled by end of simulation output
            if(monthlyOutput && i > 1) {
                displayManager.printSimulationResults(
                        trainingCentreManager.getAllTrainingCentreDTOS().size(),
                        trainingCentreManager.getFullBootCamps().size(),
                        trainingCentreManager.getFullTrainingHubs().size(),
                        WaitingListImpl.getWaitingListObj().getTrainees().size(),
                        (simulationDuration - i) + 1,
                        getNumberOfTraineesInTraining(),
                        trainingCentreManager.getAvailableBootCamps().size(),
                        trainingCentreManager.getAvailableTrainingHubs().size(),
                        bootCampsRemoved,
                        trainingCentresRemoved
                );
            }
        }

        displayManager.printSimulationResults(
                trainingCentreManager.getAllTrainingCentreDTOS().size(),
                trainingCentreManager.getFullBootCamps().size(),
                trainingCentreManager.getFullTrainingHubs().size(),
                WaitingListImpl.getWaitingListObj().getTrainees().size(),
                simulationDuration,
                getNumberOfTraineesInTraining(),
                trainingCentreManager.getAvailableBootCamps().size(),
                trainingCentreManager.getAvailableTrainingHubs().size(),
                bootCampsRemoved,
                trainingCentresRemoved
        );
    }

    protected void removeLowTraineesCentres(){
        ArrayList<TrainingCentreDTO> totalCentres = trainingCentreManager.getAllTrainingCentreDTOS();
        ArrayList<TrainingCentreDTO> clone = new ArrayList<>();
        for(TrainingCentreDTO trainingCentreDTO: totalCentres){
            clone.add(trainingCentreDTO);
        }
        for(TrainingCentreDTO centre: clone){
            ArrayList<Trainee> traineesToRemove = centre.getTraineesList();
            if(traineesToRemove.size()<25){
                WaitingListImpl waitingList = WaitingListImpl.getWaitingListObj();
                for(Trainee trainee: traineesToRemove){
                    waitingList.pushToFrontOfTheQueue(trainee);
                }

                trainingCentreManager.removeFromTotalCentres(centre);

                if(centre.getClass().getName().toLowerCase().contains("bootcamp")) {
                    if(((Bootcamp) centre).getNumMonthsUnderTwentyFiveCounter() >= 3) {
                        bootCampsRemoved++;
                        trainingCentreManager.removeFromAvailbleBootCamps((Bootcamp) centre);
                    }
                } else {
                    trainingCentresRemoved++;
                    trainingCentreManager.removeFromAvailbleTrainingHubs((TrainingHub) centre);
                }

            }
        }
    }

    private int getNumberOfTraineesInTraining() {
        int inTraining = 0;
        ArrayList<TrainingCentreDTO> centres = trainingCentreManager.getAllTrainingCentreDTOS();
        for (TrainingCentreDTO centreDTO : centres) {
            inTraining += centreDTO.getTraineesList().size();
        }

        return inTraining;
    }
}
