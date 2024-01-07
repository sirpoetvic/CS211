import java.awt.Color;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/7/24
 * Chapter 9b Assignment
 * Data structure class for Frog
 */
public class Frog implements Animal {
    private int hopNum; //Determines which hop Frog is on
    private int direction; //Current direction to hop towards

    //Constructor
    public Frog() {
        hopNum = 0;
        direction = 0;
    }

    //Frog returns "F"
    public String toString() {
        return "F";
    }

    //Moves 3 in a random direction
    @Override
    public int getMove() {
        if(hopNum == 3) {
            hopNum %= 3;
            double random = Math.random();
            
            if(random < 0.25)
                direction = NORTH;
            else if(random < 0.5)
                direction = SOUTH;
            else if(random < 0.75)
                direction = WEST;
            else
                direction = EAST;
            
        }
        hopNum++;
        return direction;
    }

    //Frogs are green
    @Override
    public Color getColor() {
        return Color.GREEN;
    }

}
