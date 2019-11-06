package se.rampoon.camel.example2;

import org.apache.camel.builder.RouteBuilder;
import se.rampoon.camel.example2.MyLogProcessor2;
import se.rampoon.camel.example2.MyTransformer2;

public class MyRouteBuilder2 extends RouteBuilder {

    @Override
    public void configure() throws Exception  {
        from("file:/home/matjav/files/inbox?move=./done").
        process(new MyLogProcessor2()).
        bean(new MyTransformer2(), "TransformContent").
        to("file:/home/matjav/files/outbox");
    }
}
