package com.acme.edu;

import com.acme.edu.formatters.AbstractFormatter;
import com.acme.edu.writers.Writer;

public class Logger {
    Writer writer;
    AbstractFormatter formatter;

    public Logger(Writer writer, AbstractFormatter formatter) {
        this.writer = writer;
        this.formatter = formatter;
    }

    public void log(Object message) {
        String formatted = formatter.format(message);
        writer.write(formatted);
    }
}
