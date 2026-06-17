package cr.ac.ucr.paraiso.The_Bug_Was_Me.view;

import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Hero;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Map;

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
        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "╔══════════════════════════════╗");
        System.out.println("║        ESTADO HÉROE         ║");
        System.out.println("╚══════════════════════════════╝"
                + ANSI_RESET);

        System.out.println(ANSI_GREEN + "Vida: "
                + hero.getCurrentLife() + "/"
                + hero.getMaxLife()
                + ANSI_RESET);

        System.out.println(ANSI_YELLOW + "Oro: "
                + hero.getGoldAccumulated()
                + ANSI_RESET);

        System.out.println(ANSI_BLUE + "Clase: "
                + hero.getTypeClass()
                + ANSI_RESET);

        System.out.println(ANSI_CYAN + "Llave: "
                + (hero.getHasKey() ? "Sí" : "No")
                + ANSI_RESET);

        System.out.println();
    }

    public void displayMessage (String message){
         System.out.println(ANSI_WHITE + message  + ANSI_RESET);
    }

    public void displayError(String message){
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    public void displayMenu(){
        // mostrar opciones: mover, atacar, usar item...
        System.out.println(ANSI_WHITE + ANSI_BOLD +
                "========== MENÚ =========="
                + ANSI_RESET);

        System.out.println(ANSI_GREEN + "[W]" + ANSI_RESET + " Arriba");
        System.out.println(ANSI_GREEN + "[S]" + ANSI_RESET + " Abajo");
        System.out.println(ANSI_GREEN + "[A]" + ANSI_RESET + " Izquierda");
        System.out.println(ANSI_GREEN + "[D]" + ANSI_RESET + " Derecha");

        System.out.println(ANSI_YELLOW + "[I]" + ANSI_RESET + " Usar Item");
        System.out.println(ANSI_CYAN + "[G]" + ANSI_RESET + " Guardar Partida");
        System.out.println(ANSI_RED + "[Q]" + ANSI_RESET + " Salir");

        System.out.println();
    }
    public void clearScreen(){
        // limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
