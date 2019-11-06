package se.rampoon.camel.example2.beans;

public class MyTransformer2 {

    public String TransformContent(String body) {
        String upperCaseContent = body.toUpperCase();
        return upperCaseContent;
    }
}
