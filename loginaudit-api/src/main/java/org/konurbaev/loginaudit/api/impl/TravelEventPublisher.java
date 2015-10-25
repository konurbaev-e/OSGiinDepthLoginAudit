package org.konurbaev.loginaudit.api.impl;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.TravelEvent;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

import java.util.Dictionary;
import java.util.Properties;

@Component(
        name = "org.konurbaev.loginaudit.publisher.travel",
        immediate = true
)
@Service(TravelEvent.class)
public class TravelEventPublisher implements TravelEvent {

    @Reference
    private EventAdmin admin;

    @Activate
    private void start() {
        System.out.println("Activating TravelEventPublisher");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void sendTravelEvent(String hotel) {
        System.out.println("sendTravelEvent is starting...");
        Dictionary payload = new Properties();
        payload.put(TravelEvent.HOTEL, hotel);
        payload.put(TravelEvent.TIMESTAMP, System.currentTimeMillis());

        Event event = new Event(TravelEvent.TOPIC, payload);

        admin.postEvent(event);
        System.out.println("sendTravelEvent is ending...");
    }
}