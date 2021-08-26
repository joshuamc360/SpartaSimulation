package com.sparta.sdets.controller;

import com.sparta.sdets.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class TrainingCentreManagerImplTest {
    private Bootcamp bootcamp = new Bootcamp();
    private TrainingHub trainingHub = new TrainingHub();
    private TrainingCentreManagerImpl trainingCentreManager = new TrainingCentreManagerImpl();

    @Test
    public void testAddingBootCamp() {
        trainingCentreManager.addCentreToBootCamp(new Bootcamp());
        Assertions.assertEquals(1, trainingCentreManager.getAvailableBootCamps().size());
    }

    @Test
    public void testAddingTrainingHubs() {
        trainingCentreManager.addCentreToTrainingHub(new TrainingHub());
        Assertions.assertEquals(1, trainingCentreManager.getAvailableTrainingHubs().size());
    }

    @Test
    public void getAvailableBootCampsTest() {
        trainingCentreManager.addCentreToBootCamp(bootcamp);
        Assertions.assertEquals(bootcamp,
                trainingCentreManager.getAvailableBootCamps().get(0));
    }

    @Test
    public void getAvailableTrainingHubsTest() {
        trainingCentreManager.addCentreToTrainingHub(trainingHub);
        Assertions.assertEquals(trainingHub,
                trainingCentreManager.getAvailableTrainingHubs().get(0));
    }


    @RepeatedTest(30)
    @DisplayName("Trainees between 0 - 50 should be added to traineesList in centre")
    void traineeListAddedToTraineeListInCentre(){
        TrainingCentreManagerImpl trainingCentreManagerImpl = new TrainingCentreManagerImpl();
        TrainingHub trainingHub = new TrainingHub();
        WaitingListImpl waitingListObj = WaitingListImpl.getWaitingListObj();
        Trainee trainee = new Trainee();

        for(int i = 0; i < 50; i ++){
            waitingListObj.push(trainee);
        }

        trainingCentreManagerImpl.addCentreToTrainingHub(trainingHub);
        trainingCentreManagerImpl.addTraineesToCentre();

        ArrayList<Trainee> expectedTraineeList = trainingHub.getTraineesList();

        System.out.println(expectedTraineeList.size());
        Assertions.assertTrue(expectedTraineeList.size()<=50);
    }

    @Test
    public void addNewTrainingHubTest(){
        int size1 = trainingCentreManager.getAllTrainingCentreDTOS().size();
        trainingCentreManager.createCentre("traininghub");
        int size2 = trainingCentreManager.getAllTrainingCentreDTOS().size();
        Assertions.assertEquals(size1 + 1, size2);
    }

    @Test
    public void addNewBootCampTest(){
        int size1 = trainingCentreManager.getAllTrainingCentreDTOS().size();
        trainingCentreManager.createCentre("bootcamp");
        int size2 = trainingCentreManager.getAllTrainingCentreDTOS().size();
        Assertions.assertEquals(size1 + 1, size2);
    }

    @Test
    @DisplayName("Tests TrainingHubs: getFullCentres, getAvailableCentres, getAllTrainingCentresDTOS")
    public void getTrainingHubsTest(){
        trainingCentreManager.createCentre("traininghub");
        int full = trainingCentreManager.getFullTrainingHubs().size();
        int available = trainingCentreManager.getAvailableTrainingHubs().size();
        int all = trainingCentreManager.getAllTrainingCentreDTOS().size();
        Assertions.assertEquals(all, full + available);
    }

    @Test
    @DisplayName("Tests BootCamps: getFullCentres, getAvailableCentres, getAllTrainingCentresDTOS")
    public void getBootCampsTest(){
        trainingCentreManager.createCentre("bootcamp");
        int full = trainingCentreManager.getFullBootCamps().size();
        int available = trainingCentreManager.getAvailableBootCamps().size();
        int all = trainingCentreManager.getAllTrainingCentreDTOS().size();
        Assertions.assertEquals(all, full + available);
    }

    @Test
    public void testRemovingBootCamp() {

        Bootcamp bootcamp = new Bootcamp();
        trainingCentreManager.addCentreToBootCamp(bootcamp);
        trainingCentreManager.removeFromAvailbleBootCamps(bootcamp);

        Assertions.assertEquals(1, trainingCentreManager.getAllTrainingCentreDTOS().size());
        Assertions.assertEquals(0, trainingCentreManager.getAvailableBootCamps().size());
    }

    @Test
    public void testRemovingTrainingHubs() {

        TrainingHub trainingHub = new TrainingHub();
        trainingCentreManager.addCentreToTrainingHub(trainingHub);
        trainingCentreManager.removeFromAvailbleTrainingHubs(trainingHub);

        Assertions.assertEquals(1, trainingCentreManager.getAllTrainingCentreDTOS().size());
        Assertions.assertEquals(0, trainingCentreManager.getAvailableTrainingHubs().size());
    }

    @Test
    public void testRemoveFromTotal() {
        TrainingHub trainingHub = new TrainingHub();
        trainingCentreManager.addCentreToTrainingHub(trainingHub);

        trainingCentreManager.removeFromTotalCentres(trainingHub);
        Assertions.assertEquals(1, trainingCentreManager.getAvailableTrainingHubs().size());
        Assertions.assertEquals(0, trainingCentreManager.getAllTrainingCentreDTOS().size());
    }

}