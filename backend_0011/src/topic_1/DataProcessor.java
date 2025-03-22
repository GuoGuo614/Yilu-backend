package topic_1;

public interface DataProcessor {
    // 生产者与消费者对 zone 进行某种操作。
    void process(ProductionDeque zone);
}
