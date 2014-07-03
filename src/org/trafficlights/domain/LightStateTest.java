package org.trafficlights.domain;

/**
 * Created by dragan on 02/07/2014.
 */

import static org.junit.Assert.*;
import static java.util.Arrays.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.trafficlights.domain.LightState.*;

import java.util.List;

@RunWith(Parameterized.class)
public class LightStateTest {

    @Parameters
    public static List<Object[]> data() {
        return asList(new Object[][] {
                { RED, RED_YELLOW },
                { RED_YELLOW, GREEN },
                { GREEN, YELLOW },
                { YELLOW, RED },
                { UNKNOWN, UNKNOWN}
        });
    }

    private LightState previousState;
    private LightState nextState;

    public LightStateTest(LightState previous, LightState next) {
        this.previousState = previous;
        this.nextState = next;
    }

    @Test
    public void testStateChange() {
        assertEquals(nextState, previousState.next());
    }
}
