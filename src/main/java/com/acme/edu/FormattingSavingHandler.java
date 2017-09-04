package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.writers.Writer;

import java.util.ArrayList;

//import java.beans.EventHandler;


public class FormattingSavingHandler implements EventHandler {
    private ArrayList<Object> buffer = new ArrayList<>();
    private int previousIndex;
    private int stringMultiplier;

    private Writer writer;
    private AbstractFormatter formatter;

    public FormattingSavingHandler(Writer writer, AbstractFormatter formatter) {
        this.writer = writer;
        this.formatter = formatter;
        previousIndex = 0;
        stringMultiplier = 1;
    }


    public void log(Integer message) {
        if (tryToAddFirstElement(message)) return;

        Object previousValue = buffer.get(previousIndex);

        if (previousValue instanceof Integer) {
            long sum = ((Integer) previousValue).intValue();
            sum += message;
            // Int overflow case
            if (sum < Integer.MAX_VALUE) {
                buffer.set(previousIndex, (int) sum);
            } else {
                buffer.set(previousIndex, (int) (sum % Integer.MAX_VALUE));
                buffer.add(Integer.MAX_VALUE);
                previousIndex++;
            }
            // Int overflow case
        } else {
            buffer.add(message);
            previousIndex++;
        }
    }

    public void log(Byte message) {
        if (tryToAddFirstElement(message)) return;

        Object previousValue = buffer.get(previousIndex);

        if (previousValue instanceof Byte) {
            int sum = ((Byte) previousValue).byteValue() + message;
            // Byte overflow case
            if (sum < Byte.MAX_VALUE) {
                buffer.set(previousIndex, (byte) sum);
            } else {
                buffer.set(previousIndex, (byte) (sum % Byte.MAX_VALUE));
                buffer.add(Byte.MAX_VALUE);
                previousIndex++;
            }
            // Byte overflow case
        } else {
            buffer.add(message);
            previousIndex++;
        }
    }

    public void log(Character message) {
        buffer.add(message);
        previousIndex++;
    }

    public void log(String message) {
        if (tryToAddFirstElement(message)) return;

        Object previousValue = buffer.get(previousIndex);

        if (previousValue instanceof String) {
            String lastString = ((String) previousValue).replace(" (x" + stringMultiplier + ")", "");
            if (lastString.equals(message)) {
                buffer.set(previousIndex, String.format(message + " (x%x)", ++stringMultiplier));
            } else {
                stringMultiplier = 1;
                buffer.add(message);
                previousIndex++;
            }
        } else {
            stringMultiplier = 1;
            buffer.add(message);
            previousIndex++;
        }
    }

    public void log(Boolean message) {
        buffer.add(message);
        previousIndex++;
    }

    public void log(Object message) {
        buffer.add(message);
        previousIndex++;
    }

    public void log(int[] message) {
        for (Integer i : message) {
            buffer.add(i);
            previousIndex++;
        }
    }

    public void releaseBuffer() {
        Object formattedBuffer = formatter.format(buffer);
        writer.write(formattedBuffer);
    }

    @Override
    public ArrayList<Object> getBuffer() {
        return buffer;
    }

    private boolean tryToAddFirstElement(Object message) {
        if (buffer.size() == 0) {
            buffer.add(message);
            return true;
        }
        return false;
    }

    @Override
    public void handleEvent(String msg) {
        log(msg);
    }

    @Override
    public void handleEvent(Integer msg) {
        log(msg);
    }

    @Override
    public void handleEvent(Byte msg) {
        log(msg);
    }

    @Override
    public void handleEvent(Boolean msg) {
        log(msg);
    }

    @Override
    public void handleEvent(Character msg) {
        log(msg);
    }

    @Override
    public void handleEvent(Object msg) {
        log(msg);
    }

    @Override
    public void handleEvent(int[] msg) {
        log(msg);
    }
}
