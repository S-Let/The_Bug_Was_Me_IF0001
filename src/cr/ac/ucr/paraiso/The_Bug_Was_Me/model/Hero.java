package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;

public class Hero extends Character{
    private String typeClass;
    private int goldAccumulated;
    private boolean hasKey;
    private Item[] inventory;


    public Hero(String name, int currentLife, int maxLife, int attackStrength, int posX, int posY, String typeClass, int goldAccumulated, boolean hasKey) {
        super(name, currentLife, maxLife, attackStrength, posX, posY);
        this.typeClass = typeClass;
        this.goldAccumulated = goldAccumulated;
        this.hasKey = hasKey;
        inventory = new Item[10];
    }

    public void move (char address, Map map){

    }

    public boolean useItem (int index){
        return true;
    }

    public boolean addItem (Item item){
        return true;
    }
    //falta atack

    public String getTypeClass() {
        return typeClass;
    }

    public void setTypeClass(String typeClass) {
        this.typeClass = typeClass;
    }

    public int getGoldAccumulated() {
        return goldAccumulated;
    }

    public void setGoldAccumulated(int goldAccumulated) {
        this.goldAccumulated = goldAccumulated;
    }

    public boolean getHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public Item[] getInventory() {
        return inventory;
    }

    public void setInventory(Item[] inventory) {
        this.inventory = inventory;
    }
}
