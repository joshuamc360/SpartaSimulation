package com.sparta.controller.view;

public interface Displayable {
    public void printGetMonths(int monts);
    public void printSimulationResults(int fullCentres, int waitingListSize, int months, int totalTraining, int notFullCentres);
}
