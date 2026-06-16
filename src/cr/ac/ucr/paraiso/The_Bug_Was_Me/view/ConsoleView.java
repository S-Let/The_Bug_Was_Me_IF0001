package cr.ac.ucr.paraiso.The_Bug_Was_Me.view;

import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Hero;
import cr.ac.ucr.paraiso.The_Bug_Was_Me.model.Map;

public class ConsoleView {
    public void displayMap(Map map){
        // Mostrar el mapa
    }

    public void displayHeroStatus(Hero hero){
        //mostrar vida, oro, etc.
    }

    public void displayMessage (String message){
         System.out.println(message);
    }

    public void displayMenu(){
        // mostrar opciones: mover, atacar, usar item...
    }
    public void clearScreen(){
        // limpiar pantalla
    }
}
