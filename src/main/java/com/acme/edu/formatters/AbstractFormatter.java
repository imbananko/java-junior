package com.acme.edu.formatters;

import java.util.ArrayList;

public abstract class AbstractFormatter<T> {
    public abstract Object format(ArrayList<T> buffer);
}
