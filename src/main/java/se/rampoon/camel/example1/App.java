package se.rampoon.camel.example1;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        MyRouteBuilder routeBuilder = new MyRouteBuilder();
        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(routeBuilder);
            camelContext.start();
            Thread.sleep(5 * 60 * 1000); // lets run it for 5 min
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
