package topic_1;

public class GuoLinkedList implements LinkedList {

    @Override
    // Add a node to the last.
    public boolean addList(Node node) {
        node.prev = tail_sentinel.prev;
        node.next = tail_sentinel;
        tail_sentinel.prev.next = node;
        tail_sentinel.prev = node;
        size++;
        return true;
    }

    // Help method of the two remove methods, remove a specified node.
    private void removeNode(Node dist) {
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
        for (Node ptr = head_sentinel.next; ptr != tail_sentinel; ptr = ptr.next) {
            if (ptr.item == value) {
                removeNode(ptr);
            }
        }
    }

    @Override
    // Find the first node which has a special value, return it's index.
    public int find(int value) {
        int count = 0;
        for (Node ptr = head_sentinel.next; ptr.item != value; ptr = ptr.next, count++) {
            if (ptr == tail_sentinel) {
                return -1;
            }
        }
        return count;
    }

    @Override
    // Return the size of the LinkedList.
    public int size() {
        return size;
    }

    // Constructor.
    public GuoLinkedList() {
        head_sentinel = new Node(-1, null, null);
        tail_sentinel = new Node(-1, head_sentinel, null);
        head_sentinel.next = tail_sentinel;
    }

    private Node head_sentinel;
    private Node tail_sentinel;
    private int size;
}
