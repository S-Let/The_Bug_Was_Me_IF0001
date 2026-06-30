package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;

public class Item {
    private String name;
    private String description;
    private String itemType;
    private int effectValue;

    public void applyEffect(Hero hero) {

        if(itemType.equals("POCION_VIDA")) {

            int newLife = hero.getCurrentLife() + effectValue;

            if(newLife > hero.getMaxLife()) {
                newLife = hero.getMaxLife();
            }

            hero.setCurrentLife(newLife);
        }

        else if(itemType.equals("ARMA_ATAQUE")) {

            hero.setAttackStrength(
                    hero.getAttackStrength() + effectValue
            );
        }
    }
}
