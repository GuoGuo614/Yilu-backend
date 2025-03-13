package topic_3;

// Create Node of LinkedList to carry value(Integer)
public class Node<T> {
    public T item;
    public Node<T> prev;
    public Node<T> next;

    public Node(T i, Node<T> aPrev, Node<T> aNext){
        item = i;
        prev = aPrev;
        next = aNext;
    }
}
