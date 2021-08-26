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
    private static int centresRemoved = 0;

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
                //System.out.println(i + " creating new training centre");
                trainingCentreManager.createCentre();
            }

            //Allocating trainees to available centres
            trainingCentreManager.addTraineesToCentre();

            //TODO: Richard
            //Checking training centres
            //Closing training centres

            //Start removing centres 3 months in
            if(simulationDuration - i > 2) {
                removeLowTraineesCentres();
            }

            //TODO: Monthly Output
            //Don't do a monthly output on the last month - handled by end of simulation output
            if(monthlyOutput && i > 1) {
                displayManager.printSimulationResults(
                        //Closed centres + available centres = all centres
                        trainingCentreManager.getAllTrainingCentreDTOS().size(),
                        trainingCentreManager.getFullCentres().size(),
                        this.waitingList.getTrainees().size(),
                        (simulationDuration - i) + 1,
                        getNumberOfTraineesInTraining(),
                        trainingCentreManager.getAvailableCentres().size(),
                        centresRemoved
                );
            }


            }

        displayManager.printSimulationResults(
                //Closed centres + available centres = all centres
                trainingCentreManager.getAllTrainingCentreDTOS().size(),
                trainingCentreManager.getFullCentres().size(),
                this.waitingList.getTrainees().size(),
                simulationDuration,
                getNumberOfTraineesInTraining(),
                trainingCentreManager.getAvailableCentres().size(),
                centresRemoved
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
                trainingCentreManager.removeFromAvailbleCentres(centre);
                trainingCentreManager.removeFromTotalCentres(centre);
                centresRemoved ++;
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
