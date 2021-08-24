package com.sparta.sdets.view;

public interface Displayable {
    public void printGetMonths(int months);
    public void printSimulationResults(int fullCentres, int waitingListSize, int months, int totalTraining, int notFullCentres);
}
