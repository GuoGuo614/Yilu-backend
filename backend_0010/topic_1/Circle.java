package topic_1;

public class Circle implements Perarea {
    public Circle() {
        radius = 5;
    }

    @Override
    // Get the area of the circle.
    public double get_area() {
        return radius * radius * Math.PI;
    }

    @Override
    // Get the perimeter of the circle.
    public double get_perimeter() {
        return 2 * radius * Math.PI;
    }

    // Get the radius.
    public double getRadius() {
        return radius;
    }

    private double radius;
}
