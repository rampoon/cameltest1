package se.rampoon.camel.example1;

public class MyTransformer {

    public String TransformContent(String body) {
        String upperCaseContent = body.toUpperCase();
        return upperCaseContent;
    }
}
