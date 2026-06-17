package cr.ac.ucr.paraiso.The_Bug_Was_Me.model;
import java.util.Random;

public class Map {
    private Cell [][] grid;
    private Enemy[] enemies;

    public Map(){
        grid = new Cell[10][10];
        enemies = new Enemy[4];
        inicializeMap();
    }

    public void inicializeMap (){
        grid = new Cell[10][10];
        String[] design = {
                "##########",
                "#@.......#",
                "#..###...#",
                "#........#",
                "####..####",
                "#........#",
                "#..###...#",
                "#...K....#",
                "#......D.#",
                "##########"
        };

        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j++){

                char symbol = design[i].charAt(j);

                switch (symbol){
                    case '#':
                        grid[i][j] = new Cell('#', false);
                        break;

                    case '.':
                        grid[i][j] = new Cell('.', true);
                        break;

                    case '@':
                        grid[i][j] = new Cell('.', true); // posición inicial del héroe
                        break;

                    case 'K':
                        grid[i][j] = new Cell('K', true);
                        break;

                    case 'D':
                        grid[i][j] = new Cell('D', true);
                        break;

                }
            }
        }
    }

    public boolean isCellTransitable (int x, int y){
        if (!isValidPosition(x,y)){
            return false;
        }

        return grid[x][y].isTransitable();
    }

    public Cell getCell(int x, int y){
        if (!isValidPosition(x,y)){
            return null;
        }
        return grid[x][y];
    }

    public boolean isValidPosition(int x, int y){
        return x >=0 && x < grid.length &&
                y >= 0 && y < grid[0].length;
    }

    public void placeHero(Hero hero) {
        if(isCellTransitable(1,1)){
            hero.setPosX(1);
            hero.setPosY(1);
    }

    }

    public void placeEnemy(Enemy enemy){ //Genera cordenadas aleatorias, verifica que sean validas,
        // verifica que no haya otro enemigo, asigna la posicion, lo regisra en el arreglo de enemigos
        Random random = new Random();
        int x;
        int y;
        do {       //grid.length cantidad de filas (X)
                   //grid[0].length cantidad de columnas (Y)
            x = random.nextInt(grid.length);
            y = random.nextInt(grid[0].length);
        } while (
                !isCellTransitable(x,y) ||
                 hasEnemyAt(x,y)
        );
        enemy.setPosX(x);
        enemy.setPosY(y);

        for(int i = 0; i < enemies.length; i ++){
            if (enemies[i] == null){
                enemies[i] = enemy;
                return;
            }
        }
    }

    public Enemy getEnemyAt (int x, int y){

        for(Enemy enemy : enemies){
            if (enemy != null && enemy.getPosX() == x &&
            enemy.getPosY() == y){
                return enemy;
            }
        }
        return null;
    }

    public boolean hasEnemyAt(int x, int y){
        return getEnemyAt(x,y) != null;
    }

    public void removeEnemy(Enemy enemy){
        for (int i = 0; i <enemies.length; i ++){
            if( enemies[i] == enemy){
                enemies[i] = null;
                return;
            }
        }
    }

    public int [] getDoorPosition(){

        //int[] position = {8,7};
        //return position;
        //otra forma de ponerlo es así
        return new int[]{8,7};//poner aquí la posición de la llave {4,8}(por ejemplo);
    }

    public int[] getKeyPosition(){
        return new int[]{7,4};//poner aquí la posición de la puerta {7,4}(por ejemplo);
    }


}
