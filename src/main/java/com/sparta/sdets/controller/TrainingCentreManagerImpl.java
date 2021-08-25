package com.sparta.sdets.controller;

import com.sparta.sdets.model.*;

import java.util.ArrayList;


public class TrainingCentreManagerImpl implements TrainingCentreManager {

    private ArrayList<TrainingCentreDTO> allTrainingCentreDTOS = new ArrayList<>();
    private ArrayList<TrainingCentreDTO> fullTrainingCentreDTOS = new ArrayList<>();
    private ArrayList<TrainingCentreDTO> availableTrainingCentreDTOS = new ArrayList<>();


    @Override
    public int getAvailability(TrainingCentreDTO trainingCentreDTO) {
        return trainingCentreDTO.getCapacity();
    }

    @Override
    public void createCentre() {
        addCentreToList((TrainingCentreDTO) new TrainingCentre());
    }

    @Override
    public ArrayList getFullCentres() {
        return fullTrainingCentreDTOS;
    }

    @Override
    public ArrayList getAvailableCentres() {
        return availableTrainingCentreDTOS;
    }

    @Override
    public void addCentreToList(TrainingCentreDTO trainingCentreDTO) {

        allTrainingCentreDTOS.add(trainingCentreDTO);
        availableTrainingCentreDTOS.add(trainingCentreDTO);
    }

    public ArrayList<TrainingCentreDTO> getAllTrainingCentreDTOS() {


        return allTrainingCentreDTOS;
    }


    public void addTraineesToCentre() {
//        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
//        int randomNumber = randomNumberGenerator.getRandomNumber(0, 20);
        WaitingListImpl waitingListObject = WaitingListImpl.getWaitingListObj();
        ArrayList<Trainee> traineesInWaitingList = waitingListObject.getTrainees();
//        if (randomNumber > traineesInWaitingList.size()) {
//            randomNumber = traineesInWaitingList.size();
//        }
//
//        for (int i = 0; i < randomNumber; i++) {
//            Trainee trainee = waitingListObject.pop(traineesInWaitingList);
//            if (trainingCentreDTO.getCapacity() < 100) {
//                getAvailableCentres().get(0);
//            }
//        }
        ArrayList<TrainingCentreDTO> clone = new ArrayList<>();
        for (TrainingCentreDTO tcDTO : availableTrainingCentreDTOS) {
            clone.add(tcDTO);

        }


        for (TrainingCentreDTO tc : clone) {
            if (waitingListObject.getTrainees().size() > 0) {
                RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
                int randomNumber = randomNumberGenerator.getRandomNumber(20, 20);

                if (randomNumber > tc.getCapacity()) {
                    randomNumber = tc.getCapacity();
                }

                for (int i = 0; i < randomNumber; i++) {
                    tc.addToQueue(waitingListObject.pop());
                }

                if (tc.getQueue().size() == 100) {

                    availableTrainingCentreDTOS.remove(tc);
                    fullTrainingCentreDTOS.add(tc);

                }
            } else {
                break;
            }

        }
    }

}



