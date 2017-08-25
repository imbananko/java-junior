package com.acme.edu;

public class TypeFormatter extends AbstractFormatter {

    @Override
    public String format(Object message) {
        if (message instanceof Integer
        || message instanceof Boolean
        || message instanceof Byte) formattedMessage = "primitive: ";
        else if (message instanceof Character) formattedMessage = "char: ";
        else if (message instanceof String) formattedMessage = "string: ";
        else formattedMessage = "reference: ";

        formattedMessage += message;
        return formattedMessage;
    }
}
