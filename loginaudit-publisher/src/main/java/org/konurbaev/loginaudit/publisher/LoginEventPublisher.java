package org.konurbaev.loginaudit.publisher;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

public class LoginEventPublisher {

    private final EventAdmin admin;

    public LoginEventPublisher(EventAdmin admin) {
        this.admin = admin;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void sendLoginEvent(String userid) {
        Dictionary payload = new Properties();
        payload.put("userid", userid);
        payload.put("timestamp", System.currentTimeMillis());

        Event event = new Event(LoginEventConstants.TOPIC, payload);

        admin.postEvent(event);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void sendTravelEvent(String hotel) {
        Dictionary payload = new Properties();
        payload.put("hotel", hotel);
        payload.put("timestamp", System.currentTimeMillis());

        Event event = new Event(TravelEventConstants.TOPIC, payload);

        admin.postEvent(event);
    }
}