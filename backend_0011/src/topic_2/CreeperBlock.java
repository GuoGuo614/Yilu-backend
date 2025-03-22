package topic_2;

// 攻击者苦力怕类
public class CreeperBlock {

    public void attack(Player p) {
        // 获取玩家对象的对象锁，进行攻击.
        synchronized (p) {
            count++;
            if (p.isDead()) {
                System.out.println(Thread.currentThread().getName() + ": player is dead.");
                endAttack();
            } else {
                p.damage(20);
                System.out.println(Thread.currentThread().getName() + " attack...");
                System.out.println(Thread.currentThread().getName() + ": 当前player的hp值 = " + p.getHp());
                if (count == 3) {
                    endAttack();
                }
            }
        }
    }

    private void endAttack() {
        System.out.println(Thread.currentThread().getName() + " end.");
    }

    // 已攻击次数记录.
    private int count = 0;
}
