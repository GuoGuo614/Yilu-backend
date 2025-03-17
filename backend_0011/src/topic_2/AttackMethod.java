package topic_2;

import java.util.concurrent.atomic.AtomicInteger;

// 同步方法实现攻击程序
public class AttackMethod {
    public static void main(String[] args) {
        Player p = new Player();
        // 原子变量，记录已攻击的次数.
        AtomicInteger countA = new AtomicInteger();
        AtomicInteger countB = new AtomicInteger();

        Runnable creeperA = () -> {
            for (int i = 0; i < 3; i++) {
                countA.getAndIncrement();
                attack(p, countA.get());
            }
        };
        Runnable creeperB = () -> {
            for (int i = 0; i < 3; i++) {
                countB.getAndIncrement();
                attack(p, countB.get());
            }
        };

        new Thread(creeperA, "Creep-A").start();
        new Thread(creeperB, "Creep-B").start();
    }

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
