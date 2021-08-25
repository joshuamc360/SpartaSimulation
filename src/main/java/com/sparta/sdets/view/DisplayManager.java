package com.sparta.sdets.view;

public class DisplayManager implements Displayable{

    @Override
    public void printGetMonths(int monts) {
        System.out.println("Running a simulation for " + monts + " months");
    }

    @Override
    public void printSimulationResults(int fullCentres, int waitingListSize, int months, int totalTraining, int notFullCentres) {
        System.out.println("After running for " + months + " you have " + fullCentres + " full centres, " + notFullCentres + "open centres, "
        + totalTraining + "Spartans in training, " + waitingListSize + " people on the waiting list");
    }

}
