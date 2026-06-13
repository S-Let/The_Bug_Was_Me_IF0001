package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;

public class Enemy extends Character {
    private int rewardGold;
    private String mosterType;

    public Enemy(String name, int currentLife, int maxLife, int attackStrength, int posX, int posY, int rewardGold, String mosterType) {
        super(name, currentLife, maxLife, attackStrength, posX, posY);
        this.rewardGold = rewardGold;
        this.mosterType = mosterType;
    }

    public void actAI (Map map,Hero hero){//vacio

    }

    public int getRewardGold() {
        return rewardGold;
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
