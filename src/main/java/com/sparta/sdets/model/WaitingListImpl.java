package com.sparta.sdets.model;

import java.util.ArrayList;

public class WaitingListImpl{
    private static WaitingListImpl waitingListObject = new WaitingListImpl();
    private static ArrayList<Trainee> waitingListTrainees = new ArrayList<>();

    //not sure
    private WaitingListImpl(){}

    public static WaitingListImpl getWaitingListObj(){
        if(waitingListObject == null){
            waitingListObject = new WaitingListImpl ();
        }
        return waitingListObject ;
    }

    public Trainee pop(ArrayList<Trainee> TraineeList) {
        int lastPositionInList = TraineeList.size()-1;
        Trainee trainee = TraineeList.get(lastPositionInList);
        TraineeList.remove(TraineeList.size()-1);
        return trainee;
    }

    public void push(Trainee trainee) {
        waitingListTrainees.add(trainee);
    }

    public ArrayList<Trainee> getTrainees() {
        return waitingListTrainees;
    }
}
