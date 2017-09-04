package com.acme.edu.exceptions;

import java.util.ArrayList;

public class FormatterException extends Exception {
    private ArrayList buffer;

    public ArrayList getBuffer() {
        return buffer;
    }

    public FormatterException(String message, ArrayList buffer) {
        super(message);
        this.buffer = buffer;
    }
}
