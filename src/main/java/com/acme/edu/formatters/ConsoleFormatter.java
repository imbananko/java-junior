package com.acme.edu.formatters;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConsoleFormatter extends AbstractFormatter<Object> {

    @Override
    public Object format(ArrayList<Object> buffer) {
        String formatted = "";

        for (Object line : buffer) {
            formatted += line.toString() + '\n';
        }
        return formatted;
//        return buffer.stream().map(Object::toString)
//                .collect(Collectors.joining("\n"));
    }
}
