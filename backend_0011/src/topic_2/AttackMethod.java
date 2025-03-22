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
                CreeperMethod.attack(p, countA.get());
            }
        };
        Runnable creeperB = () -> {
            for (int i = 0; i < 3; i++) {
                countB.getAndIncrement();
                CreeperMethod.attack(p, countB.get());
            }
        };

        new Thread(creeperA, "Creep-A").start();
        new Thread(creeperB, "Creep-B").start();
    }
}
