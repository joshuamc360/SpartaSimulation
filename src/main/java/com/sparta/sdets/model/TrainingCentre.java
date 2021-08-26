package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingCentre implements TrainingCentreDTO{
    private ArrayList<Trainee> traineesListInCentre;
    private final static int CAPACITY = 100;

    public TrainingCentre(){
        traineesListInCentre = new ArrayList<>();
    }

    @Override
    public int getCapacity() {
        return CAPACITY;
    }

    public int getRemainingSpace() {
        return CAPACITY - this.traineesListInCentre.size();
    }

    @Override
    public ArrayList getQueue() {
        return this.traineesListInCentre;
    }

    @Override
    public void addToQueue(Trainee trainee) {
        traineesListInCentre.add(trainee);
    }

    public void addTraineesToCentre(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomNumber = randomNumberGenerator.getRandomNumber(0,20);

        WaitingListImpl waitingListObject = WaitingListImpl.getWaitingListObj();
        ArrayList<Trainee> traineesInWaitingList = waitingListObject.getTrainees();

        if(randomNumber>traineesInWaitingList.size()){
            randomNumber = traineesInWaitingList.size();
        }

        for(int i = 0; i < randomNumber; i++){
            Trainee trainee = waitingListObject.pop();
            addToQueue(trainee);
        }
    }
}
