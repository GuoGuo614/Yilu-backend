public class StaticSingleton {
    // 私有构造方法
    private StaticSingleton() {}

    // 静态内部类
    private static class InnerHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    public static StaticSingleton getInstance() {
        return InnerHolder.INSTANCE;
    }
}
