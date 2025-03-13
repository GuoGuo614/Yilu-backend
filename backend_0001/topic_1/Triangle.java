package topic_1;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        Triangle first = new Triangle(3.0, 4.0, 5.0);
        Triangle second = new Triangle(1.0, 1.0, 2.0);

        // Try to get the area of triangle (3, 4, 5), may catch NotTriangle error.
        try {
            System.out.println("The area of the first triangle is: " + first.area());
        } catch (NotTriangle e) {
            System.err.println(e.getMessage());
        }

        // Try to get the area of triangle (1, 1, 2), may catch NotTriangle error.
        try {
            System.out.println("The area of the second triangle is: " + second.area());
        } catch (NotTriangle e) {
            System.err.println(e.getMessage());
        }

        Triangle third = new Triangle(-1.0, -2.0, 2.0);
        try {
            System.out.println("The area of the third triangle is: " + third.area());
        } catch (NotTriangle e) {
            System.err.println(e.getMessage());
        }
    }

    public Triangle(double x, double y, double z) {
        edges = new double[] {x, y, z};
        Arrays.sort(edges);
    }

    public double area() throws NotTriangle{
        if (!positive()) {
            throw new NotTriangle("The edges should be positive");
        }

        if (!isValid()) {
            String message = String.format("The triangle (%.3f, %.3f, %.3f) is invalid", edges[0], edges[1], edges[2]);
            throw new NotTriangle(message);
        }

        double sum = edges[0] + edges[1] + edges[2];
        double p = sum / 2;
        return Math.sqrt(p * (p - edges[0]) * (p - edges[1]) * (p - edges[2]));
    }

    // Help method of area(), ensure that the edges are positive.
    private boolean positive() {
        return edges[0] > 0 && edges[1] > 0 && edges[2] > 0;
    }

    // Help method of area(), ensure that the triangle is valid.
    private boolean isValid() {
        return !(edges[0] + edges[1] <= edges[2]);
    }

    private double[] edges;
}

