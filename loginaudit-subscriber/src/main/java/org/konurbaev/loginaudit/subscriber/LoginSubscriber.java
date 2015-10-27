package org.konurbaev.loginaudit.subscriber;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.LoginEvent;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
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

    @Activate
    private void start() {
        System.out.println("Activating LoginSubscriber");
    }

    public void handleEvent(Event event) {
        System.out.println("LoginSubscriber received event on topic = " + event.getTopic());
        System.out.println("LoginSubscriber tries Arrays.stream(event.getPropertyNames()):");
        Arrays.stream(event.getPropertyNames()).forEach(value -> System.out.println("\t" + value + " = " + event.getProperty(value)));
    }

}
