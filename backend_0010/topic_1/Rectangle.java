package topic_1;

public class Rectangle implements Perarea {
    public Rectangle() {
        width = 5;
        height = 10;
    }

    @Override
    // Get the area of rectangle.
    public double get_area() {
        return width * height;
    }

    @Override
    // Get the perimeter of rectangle.
    public double get_perimeter() {
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
