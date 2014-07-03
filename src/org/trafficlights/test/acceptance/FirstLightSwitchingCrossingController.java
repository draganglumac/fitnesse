package org.trafficlights.test.acceptance;

/**
 * Created by dragan on 03/07/2014.
 */

import org.trafficlights.domain.LightState;

public class FirstLightSwitchingCrossingController {

    LightState firstState;
    LightState secondState;

    public void setFirstLight(LightState state) {
        firstState = state;
    }

    public LightState firstLight() {
        return firstState;
    }

    public void setSecondLight(LightState state) {
        secondState = state;
    }

    public LightState secondLight() {
        return secondState;
    }

    public void execute() {
        switchFirstLight();
    }

    public void switchFirstLight() {
        if (! isValidLightStateConfiguration())
            warningConfiguration();
        else
            firstState = firstState.next();
    }

    private void warningConfiguration() {
        firstState = LightState.UNKNOWN;
        secondState = LightState.UNKNOWN;
    }

    private boolean isValidLightStateConfiguration() {
        return LightState.RED.equals(secondState) &&
                !LightState.UNKNOWN.equals(firstState);
    }
}
