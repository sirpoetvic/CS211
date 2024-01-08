import java.util.*;
/** Name	Course	Quarter		Date		Assignment
 *
 * BC CS211
 * Selected Chapter 10 Exercises
 * 
 * W.P. Iverson, January 2024
 */
public class Exercises10
{
    public static void main(String[] alot587) {
	    
        // Initialize an array of Strings, then load into a String List:
        String[] arrayS = {"four", "score", "and", "seven", "years", "ago"};
        ArrayList<String> testListS = new ArrayList<String>(); 
        ArrayList<String> testListSempty = new ArrayList<String>();
        for (String s: arrayS) testListS.add(s);
        
        // Use Iverson's CalendarDate, so we MUST use compareTo concept
        ArrayList<CalendarDate> testListC = new ArrayList<CalendarDate>();
        ArrayList<CalendarDate> testListCempty = new ArrayList<CalendarDate>();
        testListC.add(new CalendarDate(10,12,1314));  testListC.add(new CalendarDate(10,12,1314));
        testListC.add(new CalendarDate(2,14,2022));  testListC.add(new CalendarDate(3,21,2022));
         
        // Exercise 10.2
        System.out.println(testListS);
        //swapPairs(testListS);
        //swapPairs(testListSempty);
        System.out.println("10.2 swapPairs: "+ testListS); 
        System.out.println();
        
        // Exercise 10.6
        System.out.println(testListC);
        //minToFront(testListC);
        //minToFront(testListCempty);
        System.out.println("10.6 minToFront: " + testListC);
        System.out.println();
        
        // Exercise 10.7
        System.out.println(testListC);
        //removeDuplicates(testListC);
        //removeDuplicates(testListCempty);
        System.out.println("10.7 removeDuplicates: " + testListC);
        System.out.println();
        
        // Exercise 10.12
        System.out.println(testListS);
        //markLength4(testListS);
        //markLength4(testListSempty);
        System.out.println("10.12 markLength4: " + testListS);
        System.out.println();
    
        // Exercise 10.18
        System.out.println(testListS);
        //mirror(testListS);
        //mirror(testListSempty);
        System.out.println("10.18 mirror: " + testListS);
        System.out.println();
    }
}