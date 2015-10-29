package org.konurbaev.loginaudit.api.impl;

import java.util.Dictionary;
import java.util.Properties;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.LoginEvent;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        name = "org.konurbaev.loginaudit.publisher.login",
        immediate = true
)
@Service(LoginEvent.class)
public class LoginEventImpl implements LoginEvent {

    private final static Logger logger = LoggerFactory.getLogger(LoginEventImpl.class);

    @Reference
    private EventAdmin admin;

    @Activate
    private void start() {
        logger.debug("Activating LoginEventPublisher");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void sendLoginEvent(String userid) {
        logger.debug("sendLoginEvent is starting with " + userid);
        Dictionary payload = new Properties();
        payload.put(LoginEvent.USERID, userid);
        payload.put(LoginEvent.TIMESTAMP, System.currentTimeMillis());

        Event event = new Event(LoginEvent.TOPIC, payload);

        admin.postEvent(event);
        logger.debug("sendLoginEvent is ending...");
    }

}