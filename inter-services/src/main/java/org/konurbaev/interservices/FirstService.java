package org.konurbaev.interservices;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        name = "org.konurbaev.interservices.firstservice",
        immediate = true
)
@Service(FirstService.class)
public class FirstService {

    private final static Logger logger = LoggerFactory.getLogger(FirstService.class);

    @Reference
    private SecondService secondService;

    public void printHello(){
        logger.debug("FirstService Hello");
    }

    @Activate
    private void start() {
        logger.debug("Activating FirstService");
        secondService.printHello();
    }

}