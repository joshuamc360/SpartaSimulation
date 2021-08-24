package com.sparta.controller.controller;

import com.sparta.controller.model.TrainingCentre;

import java.util.ArrayList;

public class TrainingCentreManagerImpl implements TrainingCentreManager {

    ArrayList<TrainingCentre> allTrainingCentres = new ArrayList<>();
    ArrayList<TrainingCentre> fullTrainingCentres = new ArrayList<>();

    @Override
    public int getAvailability(TrainingCentre trainingCentre) {
        return trainingCentre.getCapacity();
    }

    @Override
    public void createCentre() {
        TrainingCentre trainingCentre = TrainingCentre();
    }

    @Override
    public ArrayList getFullCentres() {



        for (TrainingCentre tc : allTrainingCentres) {
            if (tc.getCapacity() == 100) {
                fullTrainingCentres.add(tc);
            }
        }
        return fullTrainingCentres;
    }

    @Override
    public ArrayList getAvailableCentres() {

        return null;
    }

    @Override
    public void addCentreToList() {

    }
}
