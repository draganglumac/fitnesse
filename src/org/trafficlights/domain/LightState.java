package org.trafficlights.domain;

/**
 * Created by dragan on 02/07/2014.
 */

public enum LightState {

    RED("red") {
        public LightState next() {
            return RED_YELLOW;
        }
    },
    RED_YELLOW("red, yellow") {
        public LightState next() {
            return GREEN;
        }
    },
    GREEN("green") {
        public LightState next() {
            return YELLOW;
        }
    },
    YELLOW("yellow") {
        public LightState next() {
            return RED;
        }
    },
    UNKNOWN("yellow blink");

    String description;

    private LightState(String description) {
        this.description = description;
    }

    public LightState next() {
      return  UNKNOWN;
    }
}
