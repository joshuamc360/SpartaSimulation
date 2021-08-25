package com.sparta.sdets.model;

import java.util.ArrayList;

public class TrainingCentre implements TrainingCentreDTO{
    private ArrayList<Trainee> traineesListInCentre;


    public TrainingCentre(){
        traineesListInCentre = new ArrayList<>();
    }

    @Override
    public int getCapacity() {
        return 0;
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
        ArrayList<Trainee> traineesInWaitingList = WaitingListImpl.getTrainees();

        for(int i = 0; i < randomNumber; i++){
            Trainee trainee = WaitingListImpl.pop(traineesInWaitingList);
            addToQueue(trainee);
        }
    }
}
