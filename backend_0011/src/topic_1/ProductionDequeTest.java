package topic_1;

// 测试程序
public class ProductionDequeTest {
    public static void main(String[] args) {
        ProductionDeque zone = new ProductionDeque(7);
        // 创建一个生产者线程，启动.
        Runnable producer1 = () -> {
            Producer p1 = new Producer();
            for (int i = 0; i < 20; i++) {
                p1.process(zone);
            }
        };
        new Thread(producer1, "producer").start();

        // 创建三个消费者线程，并启动.
        for (int i = 1; i <= 3; i++) {
            Runnable consumer = () -> {
                Consumer c1 = new Consumer();
                for (int j = 0; j < 5; j++) {
                    c1.process(zone);
                }
            };
            new Thread(consumer, "consumer" + i).start();
        }
    }
}
