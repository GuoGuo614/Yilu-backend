package topic_1;

public class PerareaTest {
    // Test.
    public static void main(String[] args) {
        Perarea rect = new Rectangle();
        Perarea circle = new Circle();
        System.out.print("The area and perimeter of the rectangle is "
                         + rect.get_area() + " and " + rect.get_perimeter());
        System.out.println();
        System.out.print("The area and perimeter of the circle is "
                         + circle.get_area() + " and " + circle.get_perimeter());
    }
}
