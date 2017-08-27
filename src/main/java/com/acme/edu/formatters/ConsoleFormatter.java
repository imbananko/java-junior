package com.acme.edu.formatters;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConsoleFormatter extends AbstractFormatter {

    @Override
    public <T> String format(ArrayList<T> buffer) {
        return buffer.stream().map(Object::toString)
                .collect(Collectors.joining("\n")) + "\n";
    }
}
