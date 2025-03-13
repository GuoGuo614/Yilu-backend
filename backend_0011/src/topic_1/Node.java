package topic_1;

// Create Node of LinkedList to carry value(Integer)
public class Node {
    public int item;
    public Node prev;
    public Node next;

    public Node(int i, Node aPrev, Node aNext){
        item = i;
        prev = aPrev;
        next = aNext;
    }
}
