package com.acme.edu;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Context {
    private List<EventHandler> handlers = new ArrayList<>();
    public Context(EventHandler... handlers) {
        this.handlers.addAll(asList(handlers));
    }

    public void logEvent(String msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void logEvent(int[] msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void logEvent(Integer msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void logEvent(Byte msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void logEvent(Boolean msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void logEvent(Character msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void logEvent(Object msg) {
        handlers.forEach(h -> h.handleEvent(msg));
    }
    public void releaseBuffer() {
        handlers.forEach(h -> h.releaseBuffer());
    }
}

