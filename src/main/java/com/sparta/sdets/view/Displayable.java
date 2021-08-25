package com.sparta.sdets.view;

public interface Displayable {
    public void printGetMonths(int months);
    //added int trainingHubs, int bootcamps, int techCentre so the breakdown can specifically see what centres are open. updated months to monthsPassed
    public void printSimulationResults(int openCentres, int fullCentres, int waitingListSize, int monthsPassed, int totalTraining, int notFullCentres);

}
