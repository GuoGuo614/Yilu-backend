package topic_1;

// 测试程序
public class ProductionDequeTest {
    public static void main(String[] args) {
        ProductionDeque zone = new ProductionDeque(7);
        // 创建一个生产者线程.
        Runnable producer1 = () -> {
            Producer p1 = new Producer();
            for (int i = 0; i < 20; i++) {
                p1.process(zone);
            }
        };

        // 创建三个消费者线程.
        Runnable consumer1 = () -> {
            Consumer c1 = new Consumer();
            for (int i = 0; i < 5; i++) {
                c1.process(zone);
            }
        };

        Runnable consumer2 = () -> {
            Consumer c2 = new Consumer();
            for (int i = 0; i < 5; i++) {
                c2.process(zone);
            }
        };

        Runnable consumer3 = () -> {
            Consumer c3 = new Consumer();
            for (int i = 0; i < 5; i++) {
                c3.process(zone);
            }
        };

        // 线程，启动.
        new Thread(producer1).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
        new Thread(consumer3).start();
    }
}
