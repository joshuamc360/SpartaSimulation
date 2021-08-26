package com.sparta.sdets.view;

import com.sparta.sdets.util.Sanitiser;

import java.security.spec.ECField;
import java.util.Scanner;

public class InputManager {/*implements Inputable{

    @Override*/


    public static int getSimulationDuration() {

        Sanitiser sanitiser = new Sanitiser();

        DisplayManager.askForInput();
        Scanner input = new Scanner(System.in);
        int months = 0;
        try {
            months = input.nextInt();
            months = sanitiser.boundingCheck(months);
        }catch (Exception e){
            DisplayManager.invalidInput();
            getSimulationDuration();
        }
        input.close();
        return months;
    }

/*    public static int getSimulationDuration() {
        DisplayManager.askForInput();
        Scanner input = new Scanner(System.in);

        int months = 0;
        months = input.nextInt();


        sanitiser.boundingCheck(months);

        input.close();
        return months;*/

}
