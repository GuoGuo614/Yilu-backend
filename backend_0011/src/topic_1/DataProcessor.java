package topic_1;

public interface DataProcessor {
    // “者”接口，生产者与消费者对 zone 进行操作
    void process(ProductionDeque zone);
}
