package com.example.project;

//DO NOT DELETE ANY METHODS BELOW
public class Player extends Sprite {
    private int treasureCount;
    private int numLives;
    private boolean win;

    public Player(int x, int y, int numLives) { //set treasureCount = 0 and numLives = 2
        super(x, y);
        treasureCount = 0;
        this.numLives = numLives;
        win = false;
    }


    public int getTreasureCount(){return treasureCount;}
    public int getLives(){return numLives;}
    public boolean getWin(){return win;}
    public String getCoords(){return "Player:" + super.getCoords();}
    public String getRowCol(int size) {return "Player:" + super.getRowCol(size);}

  
    //move method should override parent class, sprite
    public void move(String direction) { //move the (x,y) coordinates of the player
        // increments player X or Y depending on the direction parameter
        if (direction.equals("w")) {
            super.setY(getY() + 1);
        }
        else if (direction.equals("s")) {
            super.setY(getY() - 1);
        }
        else if (direction.equals("a")) {
            super.setX(getX() - 1);
        }
        else if (direction.equals("d")) {
            super.setX(getX() + 1);
        }
    }


    public void interact(int size, String direction, int numTreasures, Object obj) { // interact with an object in the position you are moving to 
        //numTreasures is the total treasures at the beginning of the game
        // loses a life when player interacts with enemy
        if (obj instanceof Enemy) {
            numLives--;
        }
        // treasureCount increments by 1 when player interacts with a treasure
        else if (obj instanceof Treasure && !(obj instanceof Trophy)) {
            treasureCount++;
        }
        // player wins if they have collected all the treasures and interacts with trophy
        else if (numTreasures == treasureCount && obj instanceof Trophy) {
            win = true;
        }
    
    }


    public boolean isValid(int size, String direction){ //check grid boundaries
        // returns true if player can still move
        if (direction.equals("w") && getY() < size - 1) {
            return true;
        }
        else if (direction.equals("s") && getY() > 0) {
            return true;
        }
        else if (direction.equals("a") && getX() > 0) {
            return true;
        }
        else if (direction.equals("d") && getX() < size - 1) {
            return true;
        }

        // if can't move, return false
        return false;
    }


   
}



