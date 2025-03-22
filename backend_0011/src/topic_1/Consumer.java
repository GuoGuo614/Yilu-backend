package topic_1;

public class Consumer implements DataProcessor {

    @Override
    public void process(ProductionDeque zone) {
        // 同步块锁住zone对象，消费.
        synchronized (zone) {
            while (zone.deque.isEmpty()) {
                try {
                    // zone为空，无法消费，线程等待.
                    System.out.println("The zone is empty, " + Thread.currentThread().getName() + " is waiting...");
                    zone.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Production result = zone.consume();
            System.out.println(Thread.currentThread().getName() + " successfully consume a production, id: " + result.getId());
            // 唤醒其他线程
            zone.notifyAll();
        }
    }
}
