package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Character {
    private int rewardGold;
    private String mosterType;

    public Enemy(String name, int currentLife, int maxLife, int attackStrength, int posX, int posY, int rewardGold, String mosterType) {
        super(name, currentLife, maxLife, attackStrength, posX, posY);
        this.rewardGold = rewardGold;
        this.mosterType = mosterType;
    }
    public static List<Enemy> crearEnemigosIniciales() {
        List<Enemy> enemigos = new ArrayList<>();

        enemigos.add(new Enemy("Esqueleto",    50, 50, 12, 2,  2,  25, "Esqueleto"));
        enemigos.add(new Enemy("Orco",         85, 85, 18, 7, 3,  45, "Orco"));
        enemigos.add(new Enemy("Murciélago",   35, 35, 10, 8, 8, 15, "Murciélago"));
        enemigos.add(new Enemy("Duende",       45, 45, 14, 3, 7, 20, "Duende"));
        enemigos.add(new Enemy("Lanzadardos",  55, 55, 16, 6,  6, 35, "Lanzadardos"));

        return enemigos;
    }
    public void actAI (Map map,Hero hero){//vacio
        if (hero == null || map == null) return;
        if (isAdjacent(hero)) {
            attack(hero);
            return;
        }

    }

    private boolean isAdjacent(Hero hero) {
        int dx = Math.abs(this.getPosX() - hero.getPosX());
        int dy = Math.abs(this.getPosY() - hero.getPosY());
        return dx <= 1 && dy <= 1 && (dx + dy > 0);
    }

    public int getRewardGold () {
        int rewardGold = 50;
        int gold = rewardGold;
        return rewardGold;
    }
    private void attack(Hero hero) {
        int damage = this.getAttackStrength();
        hero.takeDamage(damage);
        System.out.println(this.getName() + " atacó a " + hero.getName() + " por " + damage + " daño!");
    }
    public void setRewardGold(int rewardGold) {
        this.rewardGold = rewardGold;
    }
    public String getMosterType() {
        return mosterType;
    }

    public void setMosterType(String mosterType) {
        this.mosterType = mosterType;
    }
}
