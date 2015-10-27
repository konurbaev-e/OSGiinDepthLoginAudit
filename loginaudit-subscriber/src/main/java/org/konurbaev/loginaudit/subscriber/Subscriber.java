package org.konurbaev.loginaudit.subscriber;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.LoginEvent;
import org.osgi.framework.Constants;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

import java.util.Arrays;
import java.util.Dictionary;

@Component(
        name = "org.konurbaev.loginaudit.subscriber",
        immediate = true
)
@Properties({
        @Property(name = EventConstants.EVENT_TOPIC, value = {LoginEvent.TOPIC})
        })
@Service(Subscriber.class)
public class Subscriber implements EventHandler {

    @Activate
    private void start() {
        System.out.println("Activating Subscriber");
    }

    public void handleEvent(Event event) {
        System.out.println("Received event on topic = " + event.getTopic());
        System.out.println("Try Arrays.stream(event.getPropertyNames()):");
        Arrays.stream(event.getPropertyNames()).forEach(value -> System.out.println("\t" + value + " = " + event.getProperty(value)));


/*
        System.out.println("Try Arrays.asList(event.getPropertyNames()):");
        Arrays.asList(event.getPropertyNames()).forEach(value -> System.out.println("\t" + value + " = " + event.getProperty(value)));
*/
        /*event.getPropertyNames().;
        for (String propertyName : event.getPropertyNames()) {
            System.out.println("\t" + propertyName + " = " + event.getProperty(propertyName));
        }*/
    }

}
