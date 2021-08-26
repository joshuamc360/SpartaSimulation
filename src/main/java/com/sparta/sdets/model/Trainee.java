package com.sparta.sdets.model;

public class Trainee implements TraineeDTO {
    private String state;

    public Trainee() {
        this.state = "Created";
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    public void setWaiting(){this.state = "Waiting";}

    public void setAccepted(){this.state = "Accepted";}
}
