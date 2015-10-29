package org.konurbaev.loginaudit.subscriber;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.TravelEvent;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Dictionary;

@Component(
        name = "org.konurbaev.loginaudit.travelsubscriber",
        immediate = true
)
@Properties({
        @Property(name = EventConstants.EVENT_TOPIC, value = {TravelEvent.TOPIC})
})
@Service(EventHandler.class)
public class TravelSubscriber implements EventHandler {

    private final static Logger logger = LoggerFactory.getLogger(LoginSubscriber.class);

    @Activate
    private void start() {
        logger.debug("Activating TravelSubscriber");
    }

    public void handleEvent(Event event) {
        logger.debug("TravelSubscriber received event on topic = " + event.getTopic());
        Arrays.stream(event.getPropertyNames()).forEach(value -> logger.debug("\t" + value + " = " + event.getProperty(value)));
    }

}
