package topic_2;

// 同步块实现攻击程序.
public class AttackBlock {
    public static void main(String[] args) {
        Player p = new Player();
        CreeperBlock A = new CreeperBlock();
        CreeperBlock B = new CreeperBlock();

        Runnable creeperA = () -> {
            for (int i = 0; i < 3; i++) {
                A.attack(p);
            }
        };
        Runnable creeperB = () -> {
            for (int i = 0; i < 3; i++) {
                B.attack(p);
            }
        };

        new Thread(creeperA, "Creep-A").start();
        new Thread(creeperB, "Creep-B").start();
    }
}
