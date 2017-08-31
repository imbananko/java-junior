package com.acme.edu;


import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

/**
 * Created by eugene on 31/08/17.
 */

//@FunctionalInterface



public class Context {
    private List<EventHandler> handlers = new ArrayList<EventHandler>();
    public Context(EventHandler... handlers) {
        this.handlers.addAll(asList(handlers));
    }

    public void logEvent(String msg) {
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

