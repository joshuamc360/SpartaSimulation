package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingCentre implements TrainingCentreDTO{
    private ArrayList<Trainee> traineesListInCentre;


    public TrainingCentre(){
        traineesListInCentre = new ArrayList<>();
    }

    @Override
    public int getCapacity() {
        return 100 - this.traineesListInCentre.size();
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
            Trainee trainee = waitingListObject.pop(traineesInWaitingList);
            addToQueue(trainee);
        }
    }
}
