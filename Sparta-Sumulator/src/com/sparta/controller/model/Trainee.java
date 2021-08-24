package com.sparta.controller.model;

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
}
