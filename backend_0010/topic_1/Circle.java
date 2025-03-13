package topic_1;

public class Circle implements Perarea {
    public Circle() {
        radius = 5;
    }

    // Get the area of the circle.
    @Override
    public double get_area() {
        return radius * radius * Math.PI;
    }

    // Get the perimeter of the circle.
    @Override
    public double get_perimeter() {
        return 2 * radius * Math.PI;
    }

    // Get the radius.
    public double getRadius() {
        return radius;
    }

    private double radius;
}
