package org.konurbaev.loginaudit.api.impl;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.TravelEvent;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Dictionary;
import java.util.Hashtable;

@Component(
        name = "org.konurbaev.loginaudit.publisher.travel",
        immediate = true
)
@Service(TravelEvent.class)
public class TravelEventImpl implements TravelEvent {

    private final static Logger logger = LoggerFactory.getLogger(TravelEventImpl.class);

    @Reference
    private EventAdmin admin;

    @Activate
    private void start() {
        logger.debug("Activating TravelEventPublisher");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void sendTravelEvent(String hotel) {
        logger.debug("sendTravelEvent is starting with " + hotel);
        Dictionary payload = new Hashtable();
        payload.put(TravelEvent.HOTEL, hotel);
        payload.put(TravelEvent.TIMESTAMP, System.currentTimeMillis());

        Event event = new Event(TravelEvent.TOPIC, payload);

        admin.postEvent(event);
        logger.debug("sendTravelEvent is ending...");
    }
}