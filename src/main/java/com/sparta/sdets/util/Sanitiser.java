package com.sparta.sdets.util;

import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.InputManager;

public class Sanitiser{
//remove the implements since its util class ,it has to be static method
    public static int boundingCheck(int input) {
        if (input > 0 && input < 10000){
            return input;
        }
        else{
            //added this code when (-)num also it was showing positive only.
            if(input < 0)
              DisplayManager.invalidInput();
            else if(input > 10000)
                DisplayManager.invalidInputUpperBound();
           // return InputManager.getSimulationDuration();
        }
        return 0;
    }
}
