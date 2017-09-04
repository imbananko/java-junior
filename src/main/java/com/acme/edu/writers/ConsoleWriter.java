package com.acme.edu.writers;

import com.acme.edu.exceptions.WriterException;

public class ConsoleWriter implements Writer {
    @Override
    public void write(Object message) throws WriterException {
        if (message == null) throw new WriterException("Logging message is null", message);
        System.out.print(message);
    }
}
