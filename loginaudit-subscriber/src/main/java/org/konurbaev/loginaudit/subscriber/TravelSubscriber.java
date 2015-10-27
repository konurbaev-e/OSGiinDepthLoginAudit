package org.konurbaev.loginaudit.subscriber;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.TravelEvent;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

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

    @Activate
    private void start() {
        System.out.println("Activating TravelSubscriber");
    }

    public void handleEvent(Event event) {
        System.out.println("TravelSubscriber received event on topic = " + event.getTopic());
        System.out.println("TravelSubscriber tries Arrays.stream(event.getPropertyNames()):");
        Arrays.stream(event.getPropertyNames()).forEach(value -> System.out.println("\t" + value + " = " + event.getProperty(value)));
    }

}
