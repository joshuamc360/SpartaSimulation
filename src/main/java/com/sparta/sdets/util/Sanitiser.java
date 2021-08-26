package com.sparta.sdets.util;

import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.InputManager;

public class Sanitiser implements Sanitisable{
    @Override
    public int boundingCheck(int input) {
        if (input > 0 && input < 12000){
            return input;
        }
        else{
            DisplayManager.invalidInput();
            return InputManager.getSimulationDuration();
        }
    }
}
