package org.konurbaev.loginaudit.api;

public interface TravelEvent {

    static final String TOPIC = "konurbaev/travelagent/hotel";

    static final String HOTEL = "hotel";

    static final String TIMESTAMP = "timestamp";

    default public void sendTravelEvent(String userid) {

    };

}
