package topic_1;

import java.util.Deque;
import java.util.LinkedList;

public class ProductionDeque {
    // 双端队列存储生产资料
    public Deque<Production> deque;
    // 队列最大容量
    final public int capacity;
    private int nextId;

    public ProductionDeque(int n) {
        deque = new LinkedList<>();
        capacity = n;
        nextId = 0;
    }

    // 生产方法，双端队列头部添加.
    public Production produce(Object value) {
        Production obj = new Production(nextId, value);
        nextId++;
        deque.addFirst(obj);
        return obj;
    }

    // 消费方法，双端队列尾部删除.
    public Production consume() {
        return deque.removeLast();
    }
}
