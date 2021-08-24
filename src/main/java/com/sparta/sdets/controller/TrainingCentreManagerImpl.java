package com.sparta.sdets.controller;
import com.sparta.sdets.model.TrainingCentre;
import com.sparta.sdets.model.TrainingCentreDTO;

import java.util.ArrayList;


public class TrainingCentreManagerImpl implements TrainingCentreManager {

    ArrayList<TrainingCentreDTO> allTrainingCentreDTOS = new ArrayList<>();
    ArrayList<TrainingCentreDTO> fullTrainingCentreDTOS = new ArrayList<>();
    ArrayList<TrainingCentreDTO> availableTrainingCentreDTOS = new ArrayList<>();
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
        for (TrainingCentreDTO tc : allTrainingCentreDTOS) {
            if (tc.getCapacity() == 100) {
                fullTrainingCentreDTOS.add(tc);
            }
        }
        return fullTrainingCentreDTOS;
    }

    @Override
    public ArrayList getAvailableCentres() {
        for (TrainingCentreDTO tc : allTrainingCentreDTOS) {
            if (tc.getCapacity() < 100) {
                availableTrainingCentreDTOS.add(tc);
            }
        }
        return availableTrainingCentreDTOS;
    }

    @Override
    public void addCentreToList(TrainingCentreDTO trainingCentreDTO) {
        allTrainingCentreDTOS.add(trainingCentreDTO);
    }
}



