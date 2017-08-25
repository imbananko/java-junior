package com.acme.edu;

public class ConsoleWriter implements IWriter {
    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
