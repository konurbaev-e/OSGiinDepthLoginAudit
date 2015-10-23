package org.konurbaev.loginaudit.publisher;

import org.apache.felix.scr.annotations.Reference;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.EventAdmin;

public class PublisherActivator implements BundleActivator {

    @Reference
    EventAdmin eventAdmin;

    public void start(BundleContext context) throws Exception {
        LoginEventPublisher publisher = getPublisher(context);

        publisher.sendLoginEvent("anonymous");
        publisher.sendLoginEvent("alex");

        publisher.sendTravelEvent("Coral Beach");
        publisher.sendTravelEvent("Novotel");
    }

    private LoginEventPublisher getPublisher(BundleContext context) {

        //ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());

        LoginEventPublisher publisher = null;
        publisher = new LoginEventPublisher(eventAdmin);

        //if (ref != null) {
            //EventAdmin eventAdmin = (EventAdmin) context.getService(ref);

        //}

        return publisher;
    }

    public void stop(BundleContext context) throws Exception {
        // ...
    }
}
