package com.sparta.sdets.model;

import java.lang.reflect.Array;

public class Trainee implements TraineeDTO {
    private String state;
    private String courseType;

    public Trainee() {
        this.state = "Created";
        this.courseType = courseSelecter();
    }

    public String getCourseType() {
        return courseType;
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

    private String courseSelecter() {
        int courseNum = RandomNumberGenerator.getRandomNumber(0,4);
        String[] courses = {"Data", "C#", "Java", "DevOps", "Business"};
        return courses[courseNum];
    }
}
