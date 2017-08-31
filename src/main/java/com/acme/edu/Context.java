package com.acme.edu;


import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

/**
 * Created by eugene on 31/08/17.
 */

//@FunctionalInterface
 interface EventHandler {
    void handleEvent(String msg);
    void handleEvent(Integer msg);
    void handleEvent(Byte msg);
    void handleEvent(Boolean msg);
    void handleEvent(Character msg);
    void handleEvent(Object msg);

}


public class Context {
    private List<EventHandler> handlers = new ArrayList<EventHandler>();
    public Context(EventHandler... handlers) {
        this.handlers.addAll(asList(handlers));
    }

    public void logEvent(String msg) {
        handlers.forEach(handleEvent);
    }
    public void logEvent(Integer msg) {
        handlers.forEach(EventHandler::handleEvent(msg));
    }
    public void logEvent(Byte msg) {
        handlers.forEach(EventHandler::handleEvent(msg));
    }
    public void logEvent(Boolean msg) {
        handlers.forEach(EventHandler::handleEvent(msg));
    }
    public void logEvent(Character msg) {
        handlers.forEach(EventHandler::handleEvent(msg));
    }
    public void logEvent(Object msg) {
        handlers.forEach(EventHandler::handleEvent(msg));
    }


}
