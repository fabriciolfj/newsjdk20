package org.example;


public class InstanceOfRecord {

    public static void main(String[] args) {
        printSum(new Point(4, 3));
        printSum(new Point(2, 5));

        var rectangle = new Rectangle(new ColoredPoint(new Point(1, 2), new Point(4, 5)),
                new ColoredPoint(new Point(5, 7), new Point(6, 2)));
        printUpperLetColoredPoint(rectangle);
        printUpperLetColoredPointLeft(rectangle);
    }

    static void printUpperLetColoredPoint(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint ul, ColoredPoint lr)) {
            System.out.println(ul.c());
        }
    }

    static void printUpperLetColoredPointLeft(Rectangle r) {
        if (r instanceof Rectangle(ColoredPoint (Point p1, Point p2), ColoredPoint lr)) {
            System.out.println(p2.y());
        }
    }

    static void printSum(Object o) {
        if (o instanceof Point p) {
            int x = p.x();
            int y = p.y();
            System.out.println(x + y);
        }
    }

    static void printSumV2(Object o) {
        if (o instanceof Point (int x, int y)) {
            System.out.println(x + y);
        }
    }
}
