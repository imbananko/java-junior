package com.acme.edu.formatters;

import com.acme.edu.exceptions.FormatterException;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConsoleFormatter extends AbstractFormatter<Object> {

    @Override
    public Object format(ArrayList<Object> buffer) throws FormatterException {
        if (buffer == null) throw new FormatterException("Buffer cannot be null", buffer);
        if (buffer.size() == 0) throw new FormatterException("Cannot format empty buffer", buffer);

        return buffer.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
