package com.acme.edu.formatters;

import java.util.ArrayList;

public abstract class AbstractFormatter {
    protected String formattedMessage;

    public abstract <T> String format(ArrayList<T> buffer);
}
