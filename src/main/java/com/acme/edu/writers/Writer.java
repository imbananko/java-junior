package com.acme.edu.writers;

import com.acme.edu.exceptions.WriterException;

public interface Writer {
    void write(Object message) throws WriterException;
}
