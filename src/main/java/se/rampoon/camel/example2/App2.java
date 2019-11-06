package se.rampoon.camel.example2;

import org.apache.camel.CamelContext;
import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.rampoon.camel.example2.routes.Route2;

/**
 * Added: Additions in pom.xml - possible to run with 'java -jar'
 * Changed; Using org.apache.camel.main.Main as startpoint
 * Added: logging by log4j2
 */
public class App2 {
    public static void main( String[] args ) {
        final String DEFAULT_PROPERTIES_LOCATION = "classpath:application.properties";
        String location = System.getProperty("properties.location", DEFAULT_PROPERTIES_LOCATION);

        CamelContext camelContext = new DefaultCamelContext();

        try {
            Logger LOG = LoggerFactory.getLogger(Route2.class);
            LOG.info("Starting application...");
            Main camel = new Main();

            PropertiesComponent pc = new PropertiesComponent();
            pc.setLocation(location);
            camel.bind("properties",pc);
            LOG.info("Loading properties from: " + location);

            camel.addRouteBuilder(new Route2());
            try {
                camel.run();
                Thread.sleep(5 * 60 * 1000); // lets run it for 5 min
                camel.stop();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
