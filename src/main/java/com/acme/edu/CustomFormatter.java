package com.acme.edu;

public class CustomFormatter implements IFormatter {
    String formettedMessage;
    @Override
    public String format(Object message) {
        if (message instanceof Integer
        || message instanceof Boolean) formettedMessage += "primitive: ";
        if (message instanceof Character) formettedMessage += "char: ";
        if (message instanceof String) formettedMessage += "string: ";
        else formettedMessage += "reference: ";

        formettedMessage += message;
        return formettedMessage;
    }
}
