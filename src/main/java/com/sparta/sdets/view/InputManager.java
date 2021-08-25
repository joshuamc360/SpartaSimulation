package com.sparta.sdets.view;

import java.security.spec.ECField;
import java.util.Scanner;

public class InputManager {/*implements Inputable{
    @Override*/
    public static int getSimulationDuration() {
        DisplayManager.askForInput();
        Scanner input = new Scanner(System.in);
        int months = 0;
        try {
            months = input.nextInt();
        }catch (Exception e){
            DisplayManager.invalidInput();
            getSimulationDuration();
        }
        input.close();
        return months;
    }
}
