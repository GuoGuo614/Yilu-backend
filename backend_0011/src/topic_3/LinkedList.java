package topic_3;

public interface LinkedList<T> {
    boolean addList(Node<T> node);
    void removeList0();
    void removeListByValue(int value);
    int find(int value);
    int size();
}
