package org.konurbaev.interservices;

import org.apache.felix.scr.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        name = "org.konurbaev.interservices.secondservice"
)
@Service(SecondService.class)
public class SecondService {

    private final static Logger logger = LoggerFactory.getLogger(SecondService.class);

    @Reference(cardinality=ReferenceCardinality.OPTIONAL_UNARY, policy=ReferencePolicy.DYNAMIC)
    private volatile FirstService firstService;

    public void printHello(){
        logger.debug("SecondService Hello");
    }

    @Activate
    private void start() {
        logger.debug("Activating SecondService");
    }

}