package com.example.project;


//DO NOT DELETE ANY METHODS BELOW
public class Grid {
    private Sprite[][] grid;
    private int size;

    public Grid(int size) { //initialize and create a grid with all DOT objects
        this.size = size;
        grid = new Sprite[size][size];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Dot newDot = new Dot(i, j);
                grid[i][j] = newDot;
            }
        }
    }

 
    public Sprite[][] getGrid(){return grid;}



    public void placeSprite(Sprite s){ //place sprite in new spot
        grid[size - 1 - s.getY()][s.getX()] = s;
    }

    public void placeSprite(Sprite s, String direction) { //place sprite in a new spot based on direction
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] instanceof Player) {
                    grid[i][j] = new Dot(size - 1 - j,i);
                }
            }
        }

        placeSprite(s);
    }


    public void display() { //print out the current grid to the screen 
        for (Sprite[] row : grid) {
            for (Sprite col : row) {
                if (col instanceof Dot) {
                    System.out.print("🟩");
                }
                else if (col instanceof Player) {
                    System.out.print("🐒");
                }
                else if (col instanceof Enemy) {
                    System.out.print("🦁");
                }
                else if (col instanceof Trophy) {
                    System.out.print("🏆");
                }
                else if (col instanceof Treasure) {
                    System.out.print("🍌");
                }

            }
            System.out.println();
        }
    }
    
    public void gameover(){ //use this method to display a loss
    }

    public void win(){ //use this method to display a win 
    }


}