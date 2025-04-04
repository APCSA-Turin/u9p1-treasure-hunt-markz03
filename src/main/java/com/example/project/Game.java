// package com.example.project;
// import java.util.Scanner;

// public class Game{
//     private Grid grid;
//     private Player player;
//     private Enemy[] enemies;
//     private Treasure[] treasures;
//     private Trophy trophy;
//     private int size; 

//     public Game(String difficulty){ //the constructor should call initialize() and play()
//         initialize(difficulty);
//         play();
//     }

//     public static void clearScreen() { //do not modify
//         try {
//             final String os = System.getProperty("os.name").toLowerCase();
//             if (os.contains("win")) {
//                 // Windows
//                 new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//             } else {
//                 // Unix-based (Linux, macOS)
//                 System.out.print("\033[H\033[2J");
//                 System.out.flush();
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public void play(){ //write your game logic here
//         Scanner scanner = new Scanner(System.in);
//         String direction = "";
//         String playAgain = "";

//         // Loops until either player runs out of lives, wins, or chooses to quit
//         while(!direction.equals("q") && player.getLives() != 0 && !player.getWin()){
//             try {
//                 Thread.sleep(100); // Wait for 1/10 seconds
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//             clearScreen(); // Clear the screen at the beggining of the while loop

//             grid.display();
            
//             // Prints out player data/attributes
//             System.out.println(player.getCoords());
//             System.out.println(player.getRowCol(size));
//             System.out.println("Lives remaining: " + player.getLives());
//             System.out.println("Treasure collected: " + player.getTreasureCount());
//             // Gets player input
//             System.out.print("Enter a direction (w,a,s,d) or 'q' to exit: " );
//             direction = scanner.nextLine();

//             // Used to determine type of object where player will move to
//             int rowChange = 0;
//             int colChange = 0;
//             if (direction.equals("w")) {
//                 rowChange = -1;
//             }
//             else if (direction.equals("s")) {
//                 rowChange = 1;
//             }
//             else if (direction.equals("a")) {
//                 colChange = -1;
//             }
//             else if (direction.equals("d")) {
//                 colChange = 1;
//             }
            
//             // player movement, interaction, and placing player on grid
//             if (player.isValid(size, direction)) {
//                 player.interact(size, direction, 2, grid.getGrid()[size - 1 - player.getY() + rowChange][player.getX() + colChange]);
//                 if (grid.getGrid()[size - 1 - player.getY() + rowChange][player.getX() + colChange] instanceof Trophy && player.getTreasureCount() == treasures.length) {
//                     player.move(direction);
//                 }
//                 else if (!(grid.getGrid()[size - 1 - player.getY() + rowChange][player.getX() + colChange] instanceof Trophy)) {
//                     player.move(direction);
//                 }
                
//                 grid.placeSprite(player, direction);
//             }
//         }
        
//         // win/lose screen
//         clearScreen();
//         if (!player.getWin() || player.getLives() == 0) {
//             grid.gameover();
//         }
//         else if (player.getWin()) {
//             grid.win();
//         }

//         scanner.close();
            
            
     
//     }

//     public void initialize(String difficulty){
//         //to test, create a player, trophy, grid, treasure, and enemies. Then call placeSprite() to put them on the grid
//         if (difficulty.equals("easy")) {
//             grid = new Grid(5);
//             player = new Player(0, 0, 100);
//             Enemy enemy = new Enemy(3, 3);
//             Treasure treasure = new Treasure(2, 2);
//             trophy = new Trophy(4, 4);

//             enemies = new Enemy[1];
//             treasures = new Treasure[1];

//             enemies[0] = enemy;
//             treasures[0] = treasure;

//             grid.placeSprite(player);
//             grid.placeSprite(enemy);
//             grid.placeSprite(treasure);
//             grid.placeSprite(trophy);
//         }
//         else if (difficulty.equals("medium")) {
//             grid = new Grid(10);
//             player = new Player(0, 0, 3);
//             Enemy enemy = new Enemy(5, 5);
//             Enemy enemy2 = new Enemy(7,8);
//             Treasure treasure = new Treasure(2, 2);
//             Treasure treasure2 = new Treasure(1,7);
//             trophy = new Trophy(9, 9);
    
//             enemies = new Enemy[2];
//             treasures = new Treasure[2];
    
//             enemies[0] = enemy;
//             enemies[1] = enemy2;
//             treasures[0] = treasure;
//             treasures[1] = treasure2;

//             grid.placeSprite(player);
//             grid.placeSprite(enemy);
//             grid.placeSprite(enemy2);
//             grid.placeSprite(treasure);
//             grid.placeSprite(treasure2);
//             grid.placeSprite(trophy);
//         }
//         else if (difficulty.equals("hard")) {
//             grid = new Grid(20);
//             player = new Player(0, 0, 1);
//             Enemy enemy = new Enemy(5, 5);
//             Enemy enemy2 = new Enemy(7,8);
//             Enemy enemy3 = new Enemy(10, 10);
//             Enemy enemy4 = new Enemy(17,4);
//             Enemy enemy5 = new Enemy(15, 14);
//             Treasure treasure = new Treasure(2, 2);
//             Treasure treasure2 = new Treasure(3,7);
//             Treasure treasure3 = new Treasure(10, 12);
//             Treasure treasure4 = new Treasure(2,16);
//             Treasure treasure5 = new Treasure(18, 2);
//             trophy = new Trophy(19, 19);
    
//             enemies = new Enemy[5];
//             treasures = new Treasure[5];
    
//             enemies[0] = enemy;
//             enemies[1] = enemy2;
//             enemies[2] = enemy3;
//             enemies[3] = enemy4;
//             enemies[4] = enemy5;
//             treasures[0] = treasure;
//             treasures[1] = treasure2;
//             treasures[2] = treasure3;
//             treasures[3] = treasure4;
//             treasures[4] = treasure5;

//             grid.placeSprite(player);
//             grid.placeSprite(enemy);
//             grid.placeSprite(enemy2);
//             grid.placeSprite(enemy3);
//             grid.placeSprite(enemy4);
//             grid.placeSprite(enemy5);
//             grid.placeSprite(treasure);
//             grid.placeSprite(treasure2);
//             grid.placeSprite(treasure3);
//             grid.placeSprite(treasure4);
//             grid.placeSprite(treasure5);
//             grid.placeSprite(trophy);
//         }

   
//     }

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Select Game Difficulty (easy, medium, hard): ");
//         String difficulty = scanner.nextLine();
//         Game gameStart = new Game(difficulty);
//     }
// }