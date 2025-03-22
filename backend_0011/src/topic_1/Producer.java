package topic_1;

public class Producer implements DataProcessor {

    @Override
    public void process(ProductionDeque zone) {
        // 随机 value
        double value = Math.random() * 100;

        // 同步块锁住zone对象，生产.
        synchronized (zone) {
            while (zone.deque.size() == zone.capacity) {
                try {
                    // zone已满，无法生产，线程等待
                    System.out.println("The zone is full, " + Thread.currentThread().getName() + " is waiting...");
                    zone.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Production reuslt = zone.produce(value);
            System.out.println(Thread.currentThread().getName() + " successfully add a production, id: " + reuslt.getId());
            // 唤醒其它线程
            zone.notifyAll();
        }
    }
}
