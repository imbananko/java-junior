package com.acme.edu.formatters;

import java.util.ArrayList;

public abstract class AbstractFormatter<T> {
    protected String formattedMessage;
    public abstract T format(ArrayList<T> buffer);
}
