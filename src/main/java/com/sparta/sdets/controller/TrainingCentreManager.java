package com.sparta.sdets.controller;

import com.sparta.sdets.model.TrainingCentreDTO;

import java.util.ArrayList;

public interface TrainingCentreManager {
    int getAvailability(TrainingCentreDTO trainingCentre);
    void createCentre();
    ArrayList getFullCentres();
    ArrayList getAvailableCentres();
    void addCentreToList(TrainingCentreDTO trainingCentreDTO);
}
