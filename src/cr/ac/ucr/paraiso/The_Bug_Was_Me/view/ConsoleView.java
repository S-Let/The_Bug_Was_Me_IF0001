package cr.ac.ucr.paraiso.The_Bug_Was_Me.view;


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

    /**
     * Recibe una matriz de caracteres que representa el mapa
     * y la posición del héroe para mostrarla
     */

    public void displayMap(char[][] mapGrid, int heroX, int heroY, boolean[][] enemyPositions){
        // Mostrar el mapa
        for (int i = 0; i <  mapGrid.length; i++) {
            for (int j = 0; j < mapGrid[i].length; j++) {

                if (heroX == i && heroY == j){
                    System.out.print(ANSI_GREEN + ANSI_BOLD + "@ " + ANSI_RESET);

                } else if (enemyPositions[i][j]) {
                    System.out.print(ANSI_RED + ANSI_BOLD + "E " + ANSI_RESET);

                } else { char symbol = mapGrid[i][j];

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

    /**
     * Recibe los datos del héroe como valores primitivos
     */

    public void displayHeroStatus(String heroName, String heroClass, int currentLife, int maxLife, int gold, boolean hasKey){
        //mostrar vida, oro, etc.
        String llave =  hasKey ? ANSI_YELLOW + ANSI_BOLD + "K" + ANSI_CYAN : "-";


        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

        System.out.println("■ HÉROE: "
                + ANSI_GREEN + heroName
                + ANSI_WHITE + " [" + heroClass + "]");

        System.out.println("■ HP: "
                + ANSI_GREEN + currentLife + "/" + maxLife
                + ANSI_WHITE + "    ORO: "
                + ANSI_YELLOW + gold + "g");

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

    public char displayMenu(){
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
        System.out.println("■ " + ANSI_CYAN + "[L]" + ANSI_WHITE + " Cargar Partida");
        System.out.println("■ " + ANSI_RED + "[Q]" + ANSI_WHITE + " Salir");

        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
                + ANSI_RESET);

        return Character.toUpperCase(sc.next().charAt(0));
    }

    /**
     * Menú para cuando el héroe muere
     */
    public char displayGameOverMenu() {
        System.out.println(ANSI_RED + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("■         GAME OVER");
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("■ " + ANSI_WHITE + "[R]" + ANSI_WHITE + " Reiniciar");
        System.out.println("■ " + ANSI_WHITE + "[Q]" + ANSI_WHITE + " Salir");
        System.out.println(ANSI_RED + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
                + ANSI_RESET);
        return Character.toUpperCase(sc.next().charAt(0));
    }

    /**
     * Muestra los items del inventario
     */
    public void displayInventory(String[] itemNames, int[] itemEffects) {
        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("■ " + ANSI_WHITE + "INVENTARIO");
        for (int i = 0; i < itemNames.length; i++) {
            if (itemNames[i] != null) {
                System.out.println("■ [" + i + "] " + ANSI_YELLOW + itemNames[i]
                        + ANSI_WHITE + " (Efecto: " + itemEffects[i] + ")");
            } else {
                System.out.println("■ [" + i + "] " + ANSI_WHITE + "(Vacío)");
            }
        }
        System.out.println(ANSI_CYAN + ANSI_BOLD +
                "■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■"
                + ANSI_RESET);
    }

    /**
     * Obtiene la entrada del usuario para usar un item
     */
    public int getUserItemSelection() {
        System.out.print("Selecciona el índice del item a usar: ");
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void clearScreen(){
        // limpiar pantalla
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void closeScanner() {
        sc.close();
    }

}
