package com.acme.edu.handlers;

import java.util.ArrayList;

public interface EventHandler {
    void handleEvent(String msg);
    void handleEvent(Integer msg);
    void handleEvent(Byte msg);
    void handleEvent(Boolean msg);
    void handleEvent(Character msg);
    void handleEvent(Object msg);
    void handleEvent(int[] msg);
    void releaseBuffer();

    ArrayList<Object> getBuffer();
}
