public class SingletonTest {

    public static void main(String[] args) {
        // 获取两次单例类的对象
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 检查两个地址是否为同一个对象
        System.out.println(instance == instance2);
    }
}
