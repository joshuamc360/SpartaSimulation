package com.sparta.sdets.view;

    import com.sparta.sdets.model.RandomNumberGenerator;
    import com.sparta.sdets.util.Sanitiser;
    import com.sparta.sdets.view.DisplayManager;
    import com.sparta.sdets.view.InputManager;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import java.io.ByteArrayOutputStream;
    import java.io.PrintStream;
    import static org.junit.jupiter.api.Assertions .*;

    public class SanitiserTest {
        private Sanitiser sanitiser = new Sanitiser();
        private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(outputStreamCaptor));
        }

        @Test
        void boundingCheckTest() {
            int actual = sanitiser.boundingCheck(1200);
            assertEquals(1200, actual);
        }

        @Test
        void boundingUpperCheckFailCaseTest() {
            sanitiser.boundingCheck(15000);
            assertEquals("Invalid Input. Please provide a valid input between 1 and 1200!", outputStreamCaptor.toString().trim());
        }

        @Test
        void boundingLowerCheckFailCaseTest() {
            sanitiser.boundingCheck(-4);
            assertEquals("Invalid Input. Please provide a valid input between 1 and 1200!", outputStreamCaptor.toString().trim());
        }
    }
