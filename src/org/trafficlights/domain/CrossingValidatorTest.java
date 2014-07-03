package org.trafficlights.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static java.util.Arrays.asList;
import static org.trafficlights.domain.LightState.*;
import static org.junit.Assert.*;

/**
 * Created by dragan on 03/07/2014.
 */

@RunWith(Parameterized.class)
public class CrossingValidatorTest {

    @Parameters
    public static List<Object[]> values() {
        return asList(new Object[][] {
                {RED, RED, true},
                {GREEN, RED, true},
                {YELLOW, RED, true},
                {RED_YELLOW, RED, true},
                {UNKNOWN, RED, false},
                {GREEN, GREEN, false},
                {YELLOW, GREEN, false},
                {RED_YELLOW, GREEN, false},
                {RED, GREEN, true},
                {UNKNOWN, GREEN, false},
                {GREEN, RED_YELLOW, false},
                {YELLOW, RED_YELLOW, false},
                {RED, RED_YELLOW, true},
                {RED_YELLOW, RED_YELLOW, false},
                {UNKNOWN, RED_YELLOW, false},
                {GREEN, YELLOW, false},
                {YELLOW, YELLOW, false},
                {RED, YELLOW, true},
                {RED_YELLOW, YELLOW, false},
                {UNKNOWN, YELLOW, false},
                {GREEN, UNKNOWN, false},
                {YELLOW, UNKNOWN, false},
                {RED, UNKNOWN, false},
                {RED_YELLOW, UNKNOWN, false},
                {UNKNOWN, UNKNOWN, false}
        });
    }

    private LightState firstState;
    private LightState secondState;
    private boolean valid;

    public CrossingValidatorTest(LightState first, LightState second, boolean valid) {
        firstState = first;
        secondState = second;
        this.valid = valid;
    }

    @Test
    public void isValidConfiguration() {
        assertEquals(valid, new CrossingValidator().isValidConfiguration(firstState, secondState));
    }
}
