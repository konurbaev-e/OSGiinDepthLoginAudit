package org.konurbaev.loginaudit.publisher;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

@Component(
        name = "org.konurbaev.loginaudit.publisher",
        immediate = true
)
public class Publisher {

    @Reference
    private LoginEvent loginEvent;
    @Reference
    private TravelEvent travelEvent;

    @Activate
    private void start() {
        loginEvent.sendLoginEvent("alex");
        travelEvent.sendTravelEvent("john");
    }

}
