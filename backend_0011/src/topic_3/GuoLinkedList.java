package topic_3;

public class GuoLinkedList<T> implements LinkedList<T> {

    @Override
    // Add a node to the last.
    public boolean addList(Node<T> node) {
        node.prev = tailSentinel.prev;
        node.next = tailSentinel;
        tailSentinel.prev.next = node;
        tailSentinel.prev = node;
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
        removeNode(tailSentinel.prev);
    }

    @Override
    // Remove the node which has a special value.
    public void removeListByValue(int value) {
        for (Node<T> ptr = headSentinel.next; ptr != tailSentinel; ptr = ptr.next) {
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
        for (Node<T> ptr = headSentinel.next; ; ptr = ptr.next, count++) {
            if (ptr == tailSentinel) {
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
        headSentinel = new Node<>(null, null, null);
        tailSentinel = new Node<>(null, headSentinel, null);
        headSentinel.next = tailSentinel;
    }

    private Node<T> headSentinel;
    private Node<T> tailSentinel;
    private int size;
}
