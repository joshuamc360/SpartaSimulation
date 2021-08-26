package com.sparta.sdets.util;

import com.sparta.sdets.model.RandomNumberGenerator;
import com.sparta.sdets.view.DisplayManager;
import com.sparta.sdets.view.InputManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class SanitiserTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void boundingCheckTest(){


        int actual = Sanitiser.boundingCheck(1200);

        assertEquals(1200,actual );
    }

    @Test
    void boundingUpperCheckFailCaseTest(){

        Sanitiser.boundingCheck(15000);

        assertEquals("Number is greater than upper bound", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    void boundingLowerCheckFailCaseTest(){

        Sanitiser.boundingCheck(-4);

        assertEquals("Positive integers only!", outputStreamCaptor.toString()
                .trim());
    }

}
