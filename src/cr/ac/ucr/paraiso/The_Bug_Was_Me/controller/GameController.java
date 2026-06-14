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
    }

    public void processTurn(){
        // controlar turno del jugador
    }
    public void checkCombat(){
        // verifica si existe un combate
    }
    public void checkVictory(){
        // verifica victoria
    }
    public void checDefeat(){
        //verifica derrota
    }
    public void saveGame(){
        //Guarda el estado del juego
    }
    public void loadGame(){
        // Carga estado del juego
    }


}
