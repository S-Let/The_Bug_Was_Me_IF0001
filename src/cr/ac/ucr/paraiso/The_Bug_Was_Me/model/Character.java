package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;

public class Character {
    private String name;
    private int maxLife;
    private int currentLife;
    private int attackStrength;
    private int posX;
    private int posY;

    public Character(String name, int currentLife, int maxLife, int attackStrength, int posX, int posY) {
        this.name = name;
        this.currentLife = currentLife;
        this.maxLife = maxLife;
        this.attackStrength = attackStrength;
        this.posX = posX;
        this.posY = posY;
    }

    public void attack (Character target){ //personaje a objetivo

    }

    public void receiveDamage (int amount){

    }

    public boolean isAlive (){
        return true; //metodo vacio
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }

    public int getAttackStrength() {
        return attackStrength;
    }

    public void setAttackStrength(int attackStrength) {
        this.attackStrength = attackStrength;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
