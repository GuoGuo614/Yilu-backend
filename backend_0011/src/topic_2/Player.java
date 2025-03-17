package topic_2;

// 玩家类
public class Player {
    private int hp = 100;

    public void damage(int damage) {
        this.hp -= damage;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public int getHp() {
        return hp;
    }
}
