package cr.ac.ucr.paraiso.The_Bug_Was_Me.view;

import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Enemy;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Hero;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Map;

import java.util.Scanner;

public class ConsoleView {

    // Códigos ANSI para colores de consola
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private Scanner sc;

    public ConsoleView(){
        sc = new Scanner(System.in);
    }

    public void displayMap(Map map, Hero hero){
        // Mostrar el mapa
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (hero.getPosX() == i && hero.getPosY() == j){
                    System.out.print(ANSI_GREEN + ANSI_BOLD + "@ " + ANSI_RESET);

                } else if (map.hasEnemyAt(i,j)) {
                    System.out.print(ANSI_RED + ANSI_BOLD + "E " + ANSI_RESET);

                } else { char symbol = map.getCell(i,j).getSymbol();

                    switch(symbol){
                        case '#':
                            System.out.print(ANSI_BLUE + "# " + ANSI_RESET);
                            break;
                        case 'K':
                            System.out.print(ANSI_YELLOW + ANSI_BOLD + "K " + ANSI_RESET);
                            break;
                        case 'C':
                            System.out.print(ANSI_YELLOW + ANSI_BOLD + "C " + ANSI_RESET);
                            break;
                        case 'D':
                            System.out.print(ANSI_CYAN + "D " + ANSI_RESET);
                            break;
                        default:
                            System.out.print(symbol + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    public void displayHeroStatus(Hero hero){
        //mostrar vida, oro, etc.
        String llave = hero.getHasKey()
                ? ANSI_YELLOW + ANSI_BOLD + "K" + ANSI_CYAN
                : "-";

        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        System.out.println("■ HÉROE: "
                + ANSI_GREEN + hero.getName()
                + ANSI_WHITE + " [" + hero.getTypeClass() + "]");

        System.out.println("■ HP: "
                + ANSI_GREEN + hero.getCurrentLife() + "/" + hero.getMaxLife()
                + ANSI_WHITE + "    ORO: "
                + ANSI_YELLOW + hero.getGoldAccumulated() + "g");

        System.out.println("■ LLAVE: "
                + llave);

        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
                + ANSI_RESET);
    }

    public void displayMessage (String message){
         System.out.println(ANSI_WHITE + message  + ANSI_RESET);
    }

    public void displayError(String message){
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public int displayMenu(){
        // mostrar opciones: mover, atacar, usar item...
        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        System.out.println("■ " + ANSI_WHITE + "MENÚ DE ACCIONES");

        System.out.println("■ " + ANSI_GREEN + "[W]" + ANSI_WHITE + " Mover Arriba");
        System.out.println("■ " + ANSI_GREEN + "[S]" + ANSI_WHITE + " Mover Abajo");
        System.out.println("■ " + ANSI_GREEN + "[A]" + ANSI_WHITE + " Mover Izquierda");
        System.out.println("■ " + ANSI_GREEN + "[D]" + ANSI_WHITE + " Mover Derecha");

        System.out.println("■ " + ANSI_YELLOW + "[I]" + ANSI_WHITE + " Usar Item");
        System.out.println("■ " + ANSI_CYAN + "[G]" + ANSI_WHITE + " Guardar Partida");
        System.out.println("■ " + ANSI_RED + "[Q]" + ANSI_WHITE + " Salir");

        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
                + ANSI_RESET);

        return sc.nextInt();
    }

    public void clearScreen(){
        // limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
