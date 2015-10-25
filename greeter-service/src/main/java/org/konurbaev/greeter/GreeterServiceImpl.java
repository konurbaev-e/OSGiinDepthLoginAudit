package org.konurbaev.greeter;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Service;

@Component(
        immediate = true
)
@Service(GreeterService.class)
public class GreeterServiceImpl implements GreeterService {

    private String name = System.getProperty("user.name", "Scott ES");

    private String salutation = "Hello";

    @Activate
    private void start() {
        System.out.println("Activating the " + salutation);
        printGreetings();
    }

    @Override
    public void printGreetings() {
        System.out.println(salutation + " " + name);
    }
}