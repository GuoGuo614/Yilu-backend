package topic_2;

public class Rect {
    public Rect() {
        width = 10;
        height = 10;
    }

    public Rect(double aWidth, double aHeight) {
        width = aWidth;
        height = aHeight;
    }

    // Get the area of rectangle.
    public double area() {
        return width * height;
    }

    // Get the perimeter of rectangle.
    public double perimeter() {
        return 2 * (width + height);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    protected double width;
    protected double height;
}
