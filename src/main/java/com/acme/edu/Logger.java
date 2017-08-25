package com.acme.edu;

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




    /*
    private static StringBuilder internalString;
    private static boolean readyForNumber;
    private static int internalSum;
    private static String previousLoggedString;
    private static int counterForEqualString;
    private static boolean accomulationStringMode;






    public static void log(int message) {
        //dropString();
        dropCounters();
        if (!readyForNumber) {
            readyForNumber = true;
        }
        if (message != Integer.MAX_VALUE) {
            internalSum += message;
        } else {
            dropInt();
            internalSum += message;
            readyForNumber = true;
        }
    }

    public static void log(byte message) {
        //dropString();
        dropCounters();
        if (!readyForNumber) {
            readyForNumber = true;
        }
        if (message != Byte.MAX_VALUE) {
            internalSum += message;
        } else {
            dropInt();
            internalSum += message;
            readyForNumber = true;
        }
    }

    public static void log(char message) {
        //dropString();
        dropCounters();
        dropInt();
        System.out.println("char: " + message);
    }

    public static void log(String message) {
        dropInt();
        dropString(message);
        //internalString.append(message).append("\n");

        //previousLoggedString = message;

    }

    public static void log(boolean message) {
        dropInt();
        System.out.println("primitive: " + message);
    }

    public static void log(Object message) {
        //System.err.println(new StringBuilder().append("123").append(4 + 5).append(5).toString());
    }

    public static void log(int[] array) {
        String message = "primitives array: {";
        StringJoiner sj = new StringJoiner(", ");
        IntStream.of(array).forEach(x -> sj.add(String.valueOf(x)));
        message += sj.toString();
        System.out.print(message + "}\n");
    }

    public static void flush() {
        dropInt();
        System.out.print(internalString.toString());
    }

    private static void dropInt() {
        if (readyForNumber) {
            readyForNumber = false;
            internalString.append(internalSum).append("\n");
            internalSum = 0;
        }
    }

    private static void dropString(String message) {
        if (message == previousLoggedString) {
            counterForEqualString++;
            previousLoggedString = message;
            //accomulationStringMode = true;
        } else {
            //counterForEqualString = 1;
            //accomulationStringMode = false;
            if (counterForEqualString > 1) {
                internalString.append(previousLoggedString).append(" (x").
                        append(counterForEqualString).append(")").append("\n");
            } else {
                internalString.append(previousLoggedString).append("\n");
            }
        }
    }

    private static void dropCounters(){
        accomulationStringMode = false;
        previousLoggedString = "";
        counterForEqualString = 1;
    }

    public static void initialize() {
        readyForNumber = false;
        internalSum = 0;
        internalString = new StringBuilder();
        previousLoggedString = "";
        counterForEqualString = 1;
        accomulationStringMode = false;
    }
    */
}
