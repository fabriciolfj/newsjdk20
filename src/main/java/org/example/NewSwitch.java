package org.example;

public class NewSwitch {

    public static void main(String[] args) {
        var result = formatter(9L);

        System.out.println(result);
    }

    static String formatter(Object o) {
        return switch (o) {
            case null       -> "null";
            case Integer i  -> String.format("int %d", i);
            case Long i     -> String.format("long %d", i);
            case Double i   -> String.format("double %d", i);
            case String i when i.length() > 1   -> String.format("string length bigger %d", i);
            default -> o.toString();
        };
    }
}
