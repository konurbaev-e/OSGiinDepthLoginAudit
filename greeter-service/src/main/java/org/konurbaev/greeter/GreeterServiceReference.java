package org.konurbaev.greeter;

import org.apache.felix.scr.annotations.Reference;

public class GreeterServiceReference {
    @Reference
    private GreeterService greeterService;
}
