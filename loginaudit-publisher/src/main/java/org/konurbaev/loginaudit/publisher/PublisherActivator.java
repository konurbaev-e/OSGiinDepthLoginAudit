package org.konurbaev.loginaudit.publisher;

import org.apache.felix.scr.annotations.*;
import org.konurbaev.loginaudit.api.*;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

@Component(
        name = "org.konurbaev.loginaudit.publisher.activator",
        immediate = true
)
public class PublisherActivator implements BundleActivator {

    @Reference
    private LoginEvent loginEvent;
//    @Reference
//    private TravelEvent travelEvent;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("PublisherActivator start is starting...");

        //old school code
        ServiceReference serviceReference = bundleContext.getServiceReference(LoginEvent.class.getName());

        LoginEvent oldLoginEvent = (LoginEvent) bundleContext.getService(serviceReference);

        oldLoginEvent.sendLoginEvent("oldschoolcode");

        //new generation style
        loginEvent.sendLoginEvent("newgenerationstyle");

        System.out.println("PublisherActivator start is ending...");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Stopping Publisher...");
    }
}
