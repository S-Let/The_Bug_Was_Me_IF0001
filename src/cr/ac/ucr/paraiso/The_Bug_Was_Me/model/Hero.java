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
    @Override
    public void attack (Character target){
         super.attack(target);
    }

    public void move (char address, Map map){
        int x = getPosX();
        int y = getPosY();
        if (map.isCellTransitable(x, y)){
            setPosX(x);
            setPosY(y);
        }
    }

    public boolean useItem (int index){
        if (index > 0 && index < inventory.length){
            return true;
        }
        if(inventory[index] == null){
            return false;
        }
        inventory[index].appleEffect(this);

        // una vez usado sedebe eliminar el objeto(hay que hacerlo)
        return true;
    }

    public boolean addItem (Item item){
        for(int i = 0; i < inventory.length; i++){
            if(inventory[i] == null){
                inventory[i] = item;
                return true;
            }

        }
        return false;
    }

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
