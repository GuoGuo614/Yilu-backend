public class Singleton {

    // 私有构造方法
    private Singleton() {}

    // 声明私有对象
    private static volatile Singleton instance;

    // 对外提供访问对象的方式
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
