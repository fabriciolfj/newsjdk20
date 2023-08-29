package org.example;

import java.util.Arrays;

public class ForDecompose {

    public static void main(String[] args) {
        var points = Arrays.asList(new Point(1, 2), new Point(9, 8), new Point(6, 5));

        for (Point(var x, var y) : points) {
            System.out.println("x=" + x + ", y=" + y);
        }
    }
}
