package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.writers.Writer;

import java.util.ArrayList;

public class Logger {
    ArrayList<Object> buffer = new ArrayList<>();
    int previousIndex;
    int stringMultiplier;

    Writer writer;
    AbstractFormatter formatter;

    public Logger(Writer writer, AbstractFormatter formatter) {
        this.writer = writer;
        this.formatter = formatter;
        previousIndex = 0;
        stringMultiplier = 1;
    }

    public void log(Integer message) {
        if (buffer.size() == 0) {
            buffer.add(message);
            return;
        }

        Object previousValue = buffer.get(previousIndex);

        if (previousValue instanceof Integer) {
            long sum = ((Integer) previousValue).intValue();
            sum += message;
            // Int overflow case
            if (sum < Integer.MAX_VALUE) {
                buffer.set(previousIndex, (int) sum);
            } else {
                buffer.set(previousIndex, sum % Integer.MAX_VALUE);
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
        if (buffer.size() == 0) {
            buffer.add(message);
            return;
        }

        Object previousValue = buffer.get(previousIndex);

        if (previousValue instanceof Byte) {
            int sum = ((Byte) previousValue).byteValue() + message;
            // Byte overflow case
            if (sum < Byte.MAX_VALUE) {
                buffer.set(previousIndex, (byte) sum);
            } else {
                buffer.set(previousIndex, sum % Byte.MAX_VALUE);
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
        if (buffer.size() == 0) {
            buffer.add(message);
            return;
        }

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
}
