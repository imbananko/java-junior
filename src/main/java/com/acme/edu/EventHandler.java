package com.acme.edu;

import java.util.ArrayList;

/**
 * Created by eugene on 31/08/17.
 */
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
