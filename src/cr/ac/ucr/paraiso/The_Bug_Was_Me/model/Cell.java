package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;

public class Cell {
    private char symbol;
    private boolean transitable;
    private Item containedItem;

    public Cell(char symbol, boolean transitable) {
        this.symbol = symbol;
        this.transitable = transitable;
        this.containedItem = null;
    }

    public boolean hasItem (){
        return containedItem !=null;
    }

    public Item collectItem(){
        if (!hasItem()){
            return null;
        }

        Item item = containedItem;  // Guardamos el objeto
        containedItem = null; // La celda queda vacía
        return item; // Entregamos el objeto recogido
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public boolean isTransitable() {
        return transitable;
    }

    public void setTransitable(boolean transitable) {
        this.transitable = transitable;
    }

    public Item getContainedItem() {
        return containedItem;
    }

    public void setContainedItem(Item item) {
        this.containedItem = item;
    }
}
