package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.writers.Writer;

import java.util.ArrayList;

public class Logger {
    ArrayList<Object> buffer = new ArrayList<>();
    int previousNumber = 0;

    Writer writer;
    AbstractFormatter formatter;

    public Logger(Writer writer, AbstractFormatter formatter) {
        this.writer = writer;
        this.formatter = formatter;
    }

    public void log(Object message) {
        if (buffer.size() == 0) {
            buffer.add(message);
            return;
        }

        if (!tryToSum(message)) {
            buffer.add(message);
            previousNumber++;
        }

        if (message instanceof String) {
            buffer.add(message);
            previousNumber++;
        }
    }

    private boolean tryToSum(Object toSum) {
        //TODO check for string etc...
        Object previousValue = buffer.get(previousNumber);
        boolean success = true;
        if (toSum instanceof Integer) buffer.set(previousNumber, (Integer) previousValue  + (Integer) toSum);
        else if (toSum instanceof Byte) buffer.set(previousNumber, (Byte) previousValue + (Byte) toSum);
        else success = false;
        return success;
    }

    public void releaseBuffer() {
        Object formattedBuffer = formatter.format(buffer);
        writer.write(formattedBuffer);
    }
}
