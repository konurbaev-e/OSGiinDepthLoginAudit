package org.konurbaev.loginaudit.api;

public interface TravelEvent {

    String TOPIC = "konurbaev/travelagent/hotel";

    String HOTEL = "hotel";

    String TIMESTAMP = "timestamp";

    default void sendTravelEvent(String userid) {

    }

}
