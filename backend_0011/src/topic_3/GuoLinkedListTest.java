package topic_3;

import java.util.LinkedList;
import java.util.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class GuoLinkedListTest {
    @Test
    // Create a randomized test, using the built-in LinkedList as standard.
    public void LinkedListTest() {
        topic_3.LinkedList<Integer> my = new GuoLinkedList<>();
        LinkedList<Integer> other = new LinkedList<>();

        int N = 5000;
        for (int i = 0; i < N; i++) {
            Random rand = new Random();
            int option = rand.nextInt(4);

            if (option == 0) {
                // Test of addList method.
                int value = rand.nextInt(100);
                Node<Integer> node = new Node<>(value, null, null);
                boolean a = my.addList(node);
                boolean b = other.add(value);
                assertEquals(a, b);
                assertEquals(my.size(), other.size());
            } else if (option == 1) {
                // Test of removeLast method.
                if (my.size() > 0) {
                    my.removeList0();
                    other.removeLast();
                }
                assertEquals(my.size(), other.size());
            } else if (option == 3){
                // Test of find method.
                int value = rand.nextInt(100);
                int index = my.find(value);
                int except = other.indexOf(value);
                assertEquals(except, index);
            } else {
                // Test of removeListByValue method.
                int value = rand.nextInt(100);
                other.remove((Object) value);
                my.removeListByValue(value);
                assertEquals(other.size(), my.size());
            }
        }
    }

    @Test
    public void Test2() {
        topic_3.LinkedList<Integer> my = new GuoLinkedList<>();
        my.addList(new Node<>(1, null, null));
        my.addList(new Node<>(2, null, null));
        my.addList(new Node<>(2, null, null));
        my.removeListByValue(2);
        assertEquals(2, my.size());
    }
}