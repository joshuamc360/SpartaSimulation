package com.sparta.sdets.view;

public class DisplayManager implements Displayable{

    public static void askForInput(){
        System.out.println("How many months would you like to run the simulation for?: ");
    }

    public static void invalidInput(){
        System.out.println("Positive integers only!");
    }

    @Override
    public void printGetMonths(int months) {
        System.out.println("Running a simulation for " + months + " months");
    }

    @Override
    public void printSimulationResults(int openCentres, int fullCentres, int waitingListSize, int monthsPassed, int totalTraining, int notFullCentres) {
        printOpenCentres(openCentres);
        //printTotalCentres(trainingHubs, bootcamps, techCentre);printFullCentres(fullCentres);
        printTotalTraining(totalTraining);
        printWaitingListSize(waitingListSize);
        printFullCentres(fullCentres);
        printNotFullCentres(notFullCentres);
        printMonthsPassed(monthsPassed);
    }

    private void printFullCentres(int fullCentres) {
        System.out.println("There are: " + fullCentres + " full centres");
    }

    private void printWaitingListSize(int waitingListSize) {
        System.out.println("There are: " + waitingListSize + " people on the waiting list");
    }

    private void printTotalTraining(int totalTraining) {
        System.out.println("There are: " + totalTraining + " people currently training");
    }

    private void printNotFullCentres(int notFullCentres) {
        System.out.println("There are: " + notFullCentres + " centres that are NOT full");
    }

    private void printOpenCentres(int openCentres){
        System.out.println("There are " + openCentres + " total open centres");
    }

/*    @Override
    public void printTotalCentres(int trainingHubs, int bootcamps, int techCentre) {
        System.out.println("There are: " + trainingHubs + " training hubs\nThere are: " + bootcamps + "bootcamps and\nThere are: " + techCentre + "tech centres currently open");
    }*/

    private void printMonthsPassed(int monthsPassed) {
        System.out.println("After: " + monthsPassed + " months");
    }

}
