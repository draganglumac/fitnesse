package org.trafficlights.domain;

import static org.trafficlights.domain.LightState.*;

/**
 * Created by dragan on 03/07/2014.
 */
public class CrossingValidator {

    public boolean isValidConfiguration(LightState firstState, LightState secondState) {
        if (UNKNOWN.equals(firstState) || UNKNOWN.equals(secondState))
            return false;
        else if (RED.equals(firstState) || RED.equals(secondState))
            return true;
        else
            return false;
    }
}
