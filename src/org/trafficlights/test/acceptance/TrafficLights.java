package org.trafficlights.test.acceptance;

import org.trafficlights.domain.LightState;

/**
 * Created by dragan on 02/07/2014.
 */

public class TrafficLights {
    private LightState state;

    public void setPreviousState(LightState state) {
        this.state = state;
    }

    public LightState nextState() {
        return state.next();
    }
}
