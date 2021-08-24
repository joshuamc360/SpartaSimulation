package com.sparta.controller.controller;

import com.sparta.controller.model.TrainingCentre;

import java.util.ArrayList;

public interface TrainingCentreManager {
    int getAvailability(TrainingCentre trainingCentre);
    void createCentre();
    ArrayList getFullCentres();
    ArrayList getAvailableCentres();
    void addCentreToList();
}
