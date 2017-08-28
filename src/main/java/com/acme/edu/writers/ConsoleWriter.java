package com.acme.edu.writers;

public class ConsoleWriter implements Writer {
    @Override
    public void write(Object message) {
        System.out.print(message);
    }
}
