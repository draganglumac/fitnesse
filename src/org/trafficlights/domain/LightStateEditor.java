package org.trafficlights.domain;

import java.beans.PropertyEditorSupport;
import static org.trafficlights.domain.LightState.*;

/**
 * Created by dragan on 02/07/2014.
 */

public class LightStateEditor extends PropertyEditorSupport {

    public void setAsText(String state) {
        for (LightState lightState: LightState.values()) {
            if (lightState.description.equals(state)) {
                setValue(lightState);
                return;
            }
        }
        setValue(UNKNOWN);
    }

    public String getAsText() {
        LightState state = (LightState) getValue();
        return state.description;
    }
}
