package com.acme.edu.formatters;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ConsoleFormatter extends AbstractFormatter {

    @Override
    public <T> String format(ArrayList<T> buffer) {
        String formatted = "";
        for (T line : buffer) {
            formatted += line.toString() + '\n';
        }

        return formatted;
//        return buffer.stream().map(Object::toString)
//                .collect(Collectors.joining("\n")) + "\n";
    }
}
