package com.sparta.sdets.view;

public class DisplayManager{

    public static void askForInput(){
        System.out.println("How many months would you like to run the simulation for?: ");
    }

    public static void invalidInput(){
        System.out.println("Invalid Input. Please provide a valid input between 1 and 1200!");
    }

    public void printGetMonths(int months) {
        System.out.println("Running a simulation for " + months + " months");
    }

    public void printSimulationResults(int openCentres, int fullBootCamps,
                                       int fullTrainingHubs, int waitingListSize,
                                       int monthsPassed, int totalTraining,
                                       int notFullBootCamps, int notFullTrainingHubs,
                                       int numBootCampsRemoved, int numTrainingHubsRemoved) {
        printMonthsPassed(monthsPassed);
        printOpenCentres(openCentres);
        printFullBootCamps(fullBootCamps);
        printFullTrainingHubs(fullTrainingHubs);
        printTotalTraining(totalTraining);
        printWaitingListSize(waitingListSize);
        printNotFullBootCamps(notFullBootCamps);
        printNotFullTrainingHubs(notFullTrainingHubs);
        printNumBootCampsRemoved(numBootCampsRemoved);
        printNumTrainingHubsRemoved(numTrainingHubsRemoved);

        System.out.println();
    }

    private void printFullTrainingHubs(int fullTrainingHubs) {
        System.out.println("There are: " + fullTrainingHubs + " full training hubs");
    }

    private void printFullBootCamps(int fullBootCamps) {
        System.out.println("There are: " + fullBootCamps + " full boot camps");
    }

    private void printWaitingListSize(int waitingListSize) {
        System.out.println("There are: " + waitingListSize + " people on the waiting list");
    }

    private void printTotalTraining(int totalTraining) {
        System.out.println("There are: " + totalTraining + " people currently training");
    }

    private void printNotFullBootCamps(int notFullBootCamps) {
        System.out.println("There are: " + notFullBootCamps + " boot camps that are NOT full");
    }

    private void printNotFullTrainingHubs(int notFullTrainingHubs) {
        System.out.println("There are: " + notFullTrainingHubs + " training hubs that are NOT full");
    }

    private void printOpenCentres(int openCentres){
        System.out.println("There are " + openCentres + " total open centres");
    }

    private void printNumBootCampsRemoved(int numBootCampsRemoved){
        System.out.println("There are " + numBootCampsRemoved + " boot camps removed");
    }

    private void printNumTrainingHubsRemoved(int numTrainingHubsRemoved){
        System.out.println("There are " + numTrainingHubsRemoved + " training hubs removed");
    }

/*    @Override
    public void printTotalCentres(int trainingHubs, int bootcamps, int techCentre) {
        System.out.println("There are: " + trainingHubs + " training hubs\nThere are: " + bootcamps + "bootcamps and\nThere are: " + techCentre + "tech centres currently open");
    }*/

    private void printMonthsPassed(int monthsPassed) {
        System.out.println("After: " + monthsPassed + " months");
    }

    public static void printMonthlyOutputPrompt() {
        System.out.println("Do you want the simulation to output the result of each month? Y/N");
    }

}
