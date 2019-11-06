package se.rampoon.camel.example2;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyLogProcessor2 implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Now processing:" +
                " /nFromEndpoint:" + exchange.getFromEndpoint() +
                " /nFromRouteId:" + exchange.getFromRouteId() +
                " /nBody:" + exchange.getIn().getBody(String.class));
    }
}
