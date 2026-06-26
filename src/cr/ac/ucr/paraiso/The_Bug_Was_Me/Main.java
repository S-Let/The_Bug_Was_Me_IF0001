package cr.ac.ucr.paraiso.The_Bug_Was_Me;

import cr.ac.ucr.paraiso.The_Bug_Was_Me.controller.GameController;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Enemy;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Hero;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Map;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.view.ConsoleView;

public class Main {
    public static void main (String [] args){

        Hero hero = new Hero("link",100,100,20,0,0,"warrior",0,false);
        Map map = new Map();

        map.placeHero(hero);
     Enemy[] enemies = Enemy.crearEnemigosIniciales().toArray(new Enemy[0]);
      for(int i = 0; i < enemies.length; i++){
          map.placeEnemy(enemies[i]);
      }


        ConsoleView view = new ConsoleView();
        GameController controller = new GameController(hero,map,enemies,view);

        controller.startGame();

        while (hero.isAlive()){

            view.clearScreen();

            view.displayMap(map, hero);

            char option = view.displayMenu();

            switch (option) {

                case 'W':
                    controller.processTurn(-1, 0);
                    break;

                case 'S':
                    controller.processTurn(1, 0);
                    break;

                case 'A':
                    controller.processTurn(0, -1);
                    break;

                case 'D':
                    controller.processTurn(0, 1);
                    break;

                default:
                    view.displayError("Opción inválida");
            }
        }


    }
}
