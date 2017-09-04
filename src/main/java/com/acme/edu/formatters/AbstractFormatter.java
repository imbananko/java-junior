package com.acme.edu.formatters;

import com.acme.edu.exceptions.FormatterException;

import java.util.ArrayList;

public abstract class AbstractFormatter<T> {
    public abstract Object format(ArrayList<T> buffer) throws FormatterException;
}
