package com.sparta.sdets.controller;

import com.sparta.sdets.model.*;

import java.util.ArrayList;
import java.util.Collections;


public class TrainingCentreManagerImpl{

    private ArrayList<TrainingCentreDTO> allTrainingCentreDTOS = new ArrayList<>();
//    private ArrayList<TrainingCentreDTO> fullTrainingCentreDTOS = new ArrayList<>();
//    private ArrayList<TrainingCentreDTO> availableTrainingCentreDTOS = new ArrayList<>();

    private ArrayList<Bootcamp> availableBootcamps = new ArrayList<Bootcamp>();
    private ArrayList<Bootcamp> fullBootcamps = new ArrayList<Bootcamp>();

    private ArrayList<TrainingHub> availableTrainingHubs = new ArrayList<TrainingHub>();
    private ArrayList<TrainingHub> fullTrainingHubs = new ArrayList<TrainingHub>();


    //-------------------------------------------------------------------------------------

    public void createCentre(String type) {
        if(type.toLowerCase().equals("bootcamp")) {
            addCentreToBootCamp(new Bootcamp());
        } else if(type.toLowerCase().equals("traininghub")) {

            int numTrainingHubsCreated = RandomNumberGenerator.getRandomNumber(1, 3);

            for(int i = 0; i < numTrainingHubsCreated; i ++) {
                addCentreToTrainingHub(new TrainingHub());
            }

        }
    }

    public ArrayList<Bootcamp> getFullBootCamps() {
        return fullBootcamps;
    }

    public ArrayList<Bootcamp> getAvailableBootCamps() {
        return availableBootcamps;
    }

    public ArrayList<TrainingHub> getFullTrainingHubs() {
        return fullTrainingHubs;
    }

    public ArrayList<TrainingHub> getAvailableTrainingHubs() {
        return availableTrainingHubs;
    }

    public void addCentreToBootCamp(Bootcamp trainingCentreDTO) {

        allTrainingCentreDTOS.add(trainingCentreDTO);
        availableBootcamps.add(trainingCentreDTO);
    }

    public void addCentreToTrainingHub(TrainingHub trainingCentreDTO) {

        allTrainingCentreDTOS.add(trainingCentreDTO);
        availableTrainingHubs.add(trainingCentreDTO);
    }

    public ArrayList<TrainingCentreDTO> getAllTrainingCentreDTOS() {
        return allTrainingCentreDTOS;
    }

    public void removeFromAvailbleBootCamps(Bootcamp centre){
        availableBootcamps.remove(centre);
    }

    public void removeFromAvailbleTrainingHubs(TrainingHub centre){
        availableTrainingHubs.remove(centre);
    }

    public void removeFromTotalCentres(TrainingCentreDTO centre){
        allTrainingCentreDTOS.remove(centre);
    }

    public void addTraineesToCentre() {
        WaitingListImpl waitingListObject = WaitingListImpl.getWaitingListObj();

        ArrayList<TrainingCentreDTO> clone = new ArrayList<>();
        for (TrainingCentreDTO tc: availableBootcamps) {
            clone.add(tc);
        }

        ArrayList<TrainingCentreDTO> cloneTrainingHubs = new ArrayList<>();
        for (TrainingCentreDTO tc: availableTrainingHubs) {
            cloneTrainingHubs.add(tc);
        }

        clone.addAll(cloneTrainingHubs);

        Collections.shuffle(clone);


        for (TrainingCentreDTO tc : clone) {
            if (waitingListObject.getTrainees().size() > 0) {
                RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
                int randomNumber = randomNumberGenerator.getRandomNumber(0, 50);

                if (randomNumber > tc.getRemainingSpace()) {
                    randomNumber = tc.getRemainingSpace();
                } else if(randomNumber > waitingListObject.getTrainees().size() - 1) {
                    randomNumber = waitingListObject.getTrainees().size();
                }

                //TODO: ArrayList access index -1 here and crashes. WHY!?!?!!?!?!
                for (int i = 0; i < randomNumber; i++) {
                    if(waitingListObject.getTrainees().size() < 1)
                        break;

                    tc.addToQueue(waitingListObject.pop());
                }

                if (tc.getTraineesList().size() == tc.getCapacity()) {

                    if(tc.getClass().getName().toLowerCase().contains("bootcamp")) {
                        availableBootcamps.remove(tc);
                        fullBootcamps.add((Bootcamp) tc);
                    } else {
                        availableTrainingHubs.remove(tc);
                        fullTrainingHubs.add((TrainingHub) tc);
                    }
                }
            } else {
                break;
            }

        }
    }

}



