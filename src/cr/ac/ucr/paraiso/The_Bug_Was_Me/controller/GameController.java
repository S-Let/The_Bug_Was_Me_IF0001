package cr.ac.ucr.paraiso.The_Bug_Was_Me.controller;

import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Enemy;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Hero;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Map;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.view.ConsoleView;

public class GameController {
    private Hero hero;
    private Map map;
    private Enemy[] enemies;
    private ConsoleView view;

    public GameController(Hero hero, Map map, Enemy[] enemies, ConsoleView view) {
        this.hero = hero;
        this.map = map;
        this.enemies = enemies;
        this.view = view;
    }
    public void startGame(){
        // inicia juego
       view.displayMap(map,hero);
    }

    public void processTurn(int dx,int dy){
        // controlar turno del jugador
        int newx  = hero.getPosX() + dx;
        int newy = hero.getPosY() + dy;

        if(map.isCellTransitable(newx,newy)){
            hero.setPosX(newx);
            hero.setPosY(newy);
        }

        checkCombat();
        checkVictory();
        checkDefeat();
       view.displayMap(map,hero);
    }

    public void checkCombat(){
        // verifica si existe un combate
        for (int i = 0; i < enemies.length; i++){
            Enemy enemy = enemies[i];

            if (enemy!= null && hero.getPosX() == enemy.getPosX() && hero.getPosY() == enemy.getPosY()){
                view.displayMessage("Combate contra: " + enemy.getName());

                hero.attack(enemy);

                if (enemy.isAlive()){
                    enemy.attack(hero);
                    view.displayMessage("Vida de héroe: " + hero.getCurrentLife());
                } else{
                    view.displayMessage("¡Enemigo derrotado!" + enemy.getName());
                    enemies[i] = null;
                }
            }
        }
    }

    public void checkVictory(){
        // verifica victoria si elemina a todos los enemigos

        for (int i =0; i < enemies.length; i++){
            if (enemies[i] == null){
                view.displayMessage("¡Victoria!");
            }
        }


    }
    public void checkDefeat(){
        //verifica derrota
        if (!hero.isAlive()){
            view.displayError("¡Has sido derrotado!");
        }
    }
    public void saveGame(){
        //Guarda el estado del juego
    }
    public void loadGame(){
        // Carga estado del juego
    }


}
