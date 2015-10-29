package org.konurbaev.loginaudit.subscriber;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.LoginEvent;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@Component(
        name = "org.konurbaev.loginaudit.loginsubscriber",
        immediate = true
)
@Properties({
        @Property(name = EventConstants.EVENT_TOPIC, value = {LoginEvent.TOPIC})
        })
@Service(EventHandler.class)
public class LoginSubscriber implements EventHandler {

    private final static Logger logger = LoggerFactory.getLogger(LoginSubscriber.class);

    @Activate
    private void start() {
        logger.debug("Activating LoginSubscriber");
    }

    public void handleEvent(Event event) {
        logger.debug("LoginSubscriber received event on topic = " + event.getTopic());
        Arrays.stream(event.getPropertyNames()).forEach(value -> logger.debug("\t" + value + " = " + event.getProperty(value)));
    }

}
