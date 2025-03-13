package topic_3;

public interface LinkedList<T> {
    public boolean addList(Node<T> node);
    public void removeList0();
    public void removeListByValue(int value);
    public int find(int value);
    public int size();
}
