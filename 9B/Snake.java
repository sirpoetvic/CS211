import java.awt.Color;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/7/24
 * Chapter 9b Assignment
 * Data structure class for a Snake
 */
public class Snake implements Animal {
    private int slitherTarget; //How far the snake needs to slither when slithering
    private int currentSlither; //How far the snake has slithered
    private boolean isSlithering; //If the snake is currently slithering
    private boolean movingEast; //If the snake will slither east

    //Constructor
    public Snake() {
        slitherTarget = 0;
        currentSlither = 0;
        isSlithering = false;
        movingEast = false;
    }

    //Snake returns "S"
    public String toString() {
        return "S";
    }

    //Slithers east and west, alternating and increases length
    public int getMove() {
        if(currentSlither == slitherTarget) {
            isSlithering = false;
            movingEast = !movingEast;
        }

        if(isSlithering && movingEast && currentSlither < slitherTarget) {
            currentSlither++;
            return EAST;
        }
        else if(isSlithering && !movingEast && currentSlither < slitherTarget) {
            currentSlither++;
            return WEST;
        }
        else {
            isSlithering = true;
            currentSlither = 0;
            slitherTarget += 1;
            return SOUTH;
        }
    }
    
    //Snakes are red
    @Override
    public Color getColor() {
        return Color.RED;
    }
    
}