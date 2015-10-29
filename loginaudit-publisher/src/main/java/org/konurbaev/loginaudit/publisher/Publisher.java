package org.konurbaev.loginaudit.publisher;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        name = "org.konurbaev.loginaudit.publisher",
        immediate = true
)
public class Publisher {

    private final static Logger logger = LoggerFactory.getLogger(Publisher.class);

    @Reference
    private LoginEvent loginEvent;
    @Reference
    private TravelEvent travelEvent;

    @Activate
    private void start() {
        logger.debug("Activating Publisher");
        loginEvent.sendLoginEvent("alex");
        travelEvent.sendTravelEvent("mariot");
    }

}
