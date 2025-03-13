package topic_3;

public class GuoLinkedList<T> implements LinkedList<T> {

    @Override
    // Add a node to the last.
    public boolean addList(Node<T> node) {
        node.prev = tail_sentinel.prev;
        node.next = tail_sentinel;
        tail_sentinel.prev.next = node;
        tail_sentinel.prev = node;
        size++;
        return true;
    }

    // Help method of the two remove methods, remove a specified node.
    private void removeNode(Node<T> dist) {
        dist.prev.next = dist.next;
        dist.next.prev = dist.prev;
        size--;
    }

    @Override
    // Remove the last node of list.
    public void removeList0() {
        if (size == 0) {
            return;
        }
        removeNode(tail_sentinel.prev);
    }

    @Override
    // Remove the node which has a special value.
    public void removeListByValue(int value) {
        for (Node<T> ptr = head_sentinel.next; ptr != tail_sentinel; ptr = ptr.next) {
            if (ptr.item.equals(value)) {
                removeNode(ptr);
                return;
            }
        }
    }

    @Override
    // Find the first node which has a special value, return its index.
    // If not found, return -1.
    public int find(int value) {
        int count = 0;
        for (Node<T> ptr = head_sentinel.next; ; ptr = ptr.next, count++) {
            if (ptr == tail_sentinel) {
                return -1;
            } else if (ptr.item.equals(value)) {
                return count;
            }
        }
    }

    @Override
    // Return the size of the LinkedList.
    public int size() {
        return size;
    }

    // Constructor.
    public GuoLinkedList() {
        head_sentinel = new Node<>(null, null, null);
        tail_sentinel = new Node<>(null, head_sentinel, null);
        head_sentinel.next = tail_sentinel;
    }

    private Node<T> head_sentinel;
    private Node<T> tail_sentinel;
    private int size;
}
