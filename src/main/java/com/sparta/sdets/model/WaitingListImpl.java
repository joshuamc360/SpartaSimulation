package com.sparta.sdets.model;

import java.util.ArrayList;

public class WaitingListImpl{
    private static ArrayList<Trainee> waitingListTrainees;

    //not sure
    public WaitingListImpl(){
        waitingListTrainees = new ArrayList<>();
    }

    public static Trainee pop(ArrayList<Trainee> TraineeList) {
        int lastPositionInList = TraineeList.size()-1;
        Trainee trainee = TraineeList.get(lastPositionInList);
        return trainee;
    }

    public static void push(Trainee trainee) {
        waitingListTrainees.add(trainee);
    }

    public static ArrayList<Trainee> getTrainees() {
        return waitingListTrainees;
    }
}
