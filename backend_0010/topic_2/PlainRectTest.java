package topic_2;

import static org.junit.jupiter.api.Assertions.*;

class PlainRectTest {
    @org.junit.jupiter.api.Test
    public void Test1() {
        PlainRect temp = new PlainRect(10, 10, 10, 20);
        System.out.println("area: " + temp.area());
        System.out.println("perimeter: " + temp.perimeter());
        if (temp.isInside(25.5, 13)) {
            System.out.println("(25.5, 13) is inside the rect");
        } else {
            System.out.println("(25.5, 13) is not inside the rect");
        }
    }

    @org.junit.jupiter.api.Test
    public void Test2() {
        PlainRect temp = new PlainRect(0, 0, 10, 20);
        assertEquals(false, temp.isInside(0, 0));
    }

    @org.junit.jupiter.api.Test
    public void Test3() {
        PlainRect temp = new PlainRect();
        assertEquals(false, temp.isInside(0, 0));
    }
}
