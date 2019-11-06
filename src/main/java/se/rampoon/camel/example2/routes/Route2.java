package se.rampoon.camel.example2.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.rampoon.camel.example2.beans.MyLogProcessor2;
import se.rampoon.camel.example2.beans.MyTransformer2;

public class Route2 extends RouteBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(Route2.class);

    @Override
    public void configure() throws Exception {
        from("file:/home/matjav/files/inbox?move=./done")
            .log(LoggingLevel.INFO, LOG, "Starting...")
          //  .process(new MyLogProcessor2())
            .bean(new MyTransformer2(), "TransformContent")
            .to("file:/home/matjav/files/outbox");
    }
}
