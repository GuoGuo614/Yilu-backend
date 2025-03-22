package topic_2;

public class CreeperMethod {
    // 攻击方法，采用synchronized锁住当前整个类的对象.
    public static synchronized void attack(Player p, int count) {
        if (p.isDead()) {
            System.out.println(Thread.currentThread().getName() + ": player is dead.");
        } else {
            p.damage(20);
            System.out.println(Thread.currentThread().getName() + " attack...");
            System.out.println(Thread.currentThread().getName() + ": 当前player的hp值 = " + p.getHp());
        }
        if (count == 3) {
            System.out.println(Thread.currentThread().getName() + " end.");
        }
    }
}
