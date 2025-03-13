package topic_2;

public class PlainRect extends Rect {
    public PlainRect() {
        startX = 0;
        startY = 0;
        width = 0;
        height = 0;
    }

    // Constructor, initialize the position and size.
    public PlainRect(double x, double y, double aWidth, double aHeight) {
        super(x, y);
        startX = x;
        startY = y;
    }

    // Check point (x, y) is inside the rectangle or not.
    public boolean isInside(double x, double y) {
        return x > startX && x < startX + width && y > startY && y < startY + height;
    }

    private double startX;
    private double startY;
}
