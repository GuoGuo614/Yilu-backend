package topic_1;

// 生产资料
public class Production {
    // 生产资料编号及价值.
    private int id;
    private Object value;

    public Production(int anId, Object aValue) {
        id = anId;
        value = aValue;
    }

    public int getId() {
        return id;
    }
}
