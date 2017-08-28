package com.acme.edu.formatters;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArrayFormatter extends AbstractFormatter<Integer> {
    @Override
    public Object format(ArrayList<Integer> buffer) {
        String formatted = "primitives array: {";
        formatted += buffer.stream().map(Object::toString)
               .collect(Collectors.joining(", ")) + "}\n";
        return formatted;
    }
}
