package cr.ac.ucr.paraiso.The_Bug_Was_Me.controller;

import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Enemy;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Hero;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Map;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.view.ConsoleView;

public class GameController {
    private Hero hero;
    private Map map;
    private Enemy[] enemies;
    private ConsoleView console;

    public GameController(Hero hero, Map map, Enemy[] enemies, ConsoleView console) {
        this.hero = hero;
        this.map = map;
        this.enemies = enemies;
        this.console = console;
    }
    public void startGame(){
        // inicia juego
       // console.displayMap(map,hero,enemies);
    }

    public void processTurn(int dx,int dy){
        // controlar turno del jugador
        hero.setPosX(hero.getPosX() + dx);
        hero.setPosY(hero.getPosY() + dy);

        checkCombat();
        checkVictory();
        checDefeat();
       // console.displayMap(map,hero,enemies);
    }
    public void checkCombat(){
        // verifica si existe un combate
        for (int i = 0; i < enemies.length; i++){
            Enemy enemy = enemies[i];

            if (enemy!= null && hero.getPosX() == enemy.getPosX() && hero.getPosY() == enemy.getPosY()){
                System.out.println("Combate contra: " + enemy.getName());

                hero.attack(enemy);

                if (enemy.isAlive()){
                    enemy.attack(hero);
                    System.out.println("Vida de héroe: " + hero.getCurrentLife());
                } else{
                    System.out.println("¡Enemigo derrotado!" + enemy.getName());
                    enemies[i] = null; // elimina enemigo
                }
            }
        }
    }

    public void checkVictory(){
        // verifica victoria si elemina a todos los enemigos

        boolean allDead = true;
        for (int i =0; i < enemies.length; i++){
            if (enemies[i] == null){
                allDead = false;
            }
        }
        if (allDead){
            System.out.println("¡Victoria!");
        }
    }
    public void checDefeat(){
        //verifica derrota
        if (!hero.isAlive()){
            System.out.println("¡Has sido derrotado!");
        }
    }
    public void saveGame(){
        //Guarda el estado del juego
    }
    public void loadGame(){
        // Carga estado del juego
    }


}
