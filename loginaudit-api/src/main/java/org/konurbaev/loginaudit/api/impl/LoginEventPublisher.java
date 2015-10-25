package org.konurbaev.loginaudit.api.impl;

import java.util.Dictionary;
import java.util.Properties;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.LoginEvent;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

@Component(
        name = "org.konurbaev.loginaudit.publisher.login",
        immediate = true
)
@Service(LoginEvent.class)
public class LoginEventPublisher implements LoginEvent {

    @Reference
    private EventAdmin admin;

    @Activate
    private void start() {
        System.out.println("Activating LoginEventPublisher");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void sendLoginEvent(String userid) {
        System.out.println("sendLoginEvent is starting...");
        Dictionary payload = new Properties();
        payload.put(LoginEvent.USERID, userid);
        payload.put(LoginEvent.TIMESTAMP, System.currentTimeMillis());

        Event event = new Event(LoginEvent.TOPIC, payload);

        admin.postEvent(event);
        System.out.println("sendLoginEvent is ending...");
    }

}