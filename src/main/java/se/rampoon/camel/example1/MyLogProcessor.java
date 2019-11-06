package se.rampoon.camel.example1;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyLogProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Now processing:" + exchange.getIn().getBody(String.class));
    }
}
