package com.acme.edu.formatters;

public abstract class AbstractFormatter {
    protected String formattedMessage;
    public abstract String format(Object message);
}
