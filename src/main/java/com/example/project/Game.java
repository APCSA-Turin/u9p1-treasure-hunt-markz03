package com.example.project;
import java.util.Scanner;

public class Game{
    private Grid grid;
    private Player player;
    private Enemy[] enemies;
    private Treasure[] treasures;
    private Trophy trophy;
    private int size; 

    public Game(int size){ //the constructor should call initialize() and play()
        this.size = size;
        initialize(size);
        play();
    }

    public static void clearScreen() { //do not modify
        try {
            final String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                // Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Unix-based (Linux, macOS)
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){ //write your game logic here
        Scanner scanner = new Scanner(System.in);
        String direction = "";

        while(!direction.equals("q") && player.getLives() != 0 && !player.getWin()){
            try {
                Thread.sleep(100); // Wait for 1/10 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen(); // Clear the screen at the beggining of the while loop

            grid.display();
            
            System.out.println(player.getCoords());
            System.out.println(player.getRowCol(size));
            System.out.println("Lives remaining: " + player.getLives());
            System.out.println("Treasure collected: " + player.getTreasureCount());
            System.out.print("Enter a direction (w,a,s,d) or 'q' to exit: " );
            direction = scanner.nextLine();


            int rowChange = 0;
            int colChange = 0;
            if (direction.equals("w")) {
                rowChange = -1;
            }
            else if (direction.equals("s")) {
                rowChange = 1;
            }
            else if (direction.equals("a")) {
                colChange = -1;
            }
            else if (direction.equals("d")) {
                colChange = 1;
            }
            
            if (player.isValid(size, direction)) {
                player.interact(size, direction, 2, grid.getGrid()[size - 1 - player.getY() + rowChange][player.getX() + colChange]);
                if (grid.getGrid()[size - 1 - player.getY() + rowChange][player.getX() + colChange] instanceof Trophy && player.getTreasureCount() == treasures.length) {
                    player.move(direction);
                }
                else if (!(grid.getGrid()[size - 1 - player.getY() + rowChange][player.getX() + colChange] instanceof Trophy)) {
                    player.move(direction);
                }
                
                grid.placeSprite(player, direction);
            }
        }
        
        clearScreen();
        if (!player.getWin() || player.getLives() == 0) {
            
            for (int i = 0; i < grid.getGrid().length; i++) {
                for (int j = 0; j < grid.getGrid()[i].length; j++) {
                    if (!(grid.getGrid()[i][j] instanceof Player)) {
                        System.out.print("❌");;
                    }
                    else {
                        System.out.print("🐒");
                    }
                }
                System.out.println();
            }
            System.out.println("----- Game Over -----");
        }
        else if (player.getWin()) {
            for (int i = 0; i < grid.getGrid().length; i++) {
                for (int j = 0; j < grid.getGrid()[i].length; j++) {
                    if (!(grid.getGrid()[i][j] instanceof Player)) {
                        System.out.print("🥳");;
                    }
                    else {
                        System.out.print("🐒");
                    }
                }
                System.out.println();
            }
            System.out.println("----- You Win -----");
        }

        scanner.close();
            
            
     
    }

    public void initialize(int size){
        //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
        grid = new Grid(size);
        player = new Player(0, 0);
        Enemy enemy = new Enemy(5, 5);
        Enemy enemy2 = new Enemy(7,8);
        Treasure treasure = new Treasure(2, 2);
        Treasure treasure2 = new Treasure(1,7);
        trophy = new Trophy(9, 9);

        enemies = new Enemy[2];
        treasures = new Treasure[2];

        enemies[0] = enemy;
        enemies[1] = enemy2;
        treasures[0] = treasure;
        treasures[1] = treasure2;


        grid.placeSprite(player);
        grid.placeSprite(enemy);
        grid.placeSprite(enemy2);
        grid.placeSprite(treasure);
        grid.placeSprite(treasure2);
        grid.placeSprite(trophy);
   
    }

    public static void main(String[] args) {
        Game gameStart = new Game(10);
    }
}