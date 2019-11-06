package se.rampoon.camel.example1;

import org.apache.camel.builder.RouteBuilder;

public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception  {
        from("file:/home/matjav/files/inbox?move=./done").
        process(new MyLogProcessor()).
        bean(new MyTransformer(), "TransformContent").
        to("file:/home/matjav/files/outbox");
    }
}
