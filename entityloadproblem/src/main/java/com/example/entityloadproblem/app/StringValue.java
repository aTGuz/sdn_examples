package com.example.entityloadproblem.app;

public class StringValue extends AbstractNode {
    private String text;

    public StringValue() {
    }

    public StringValue(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
