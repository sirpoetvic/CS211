package Chapter_10;
import java.util.*;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/11/24
 * Chapter 10
 * Exercises for Chapter 10
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
        swapPairs(testListS);
        swapPairs(testListSempty);
        System.out.println("10.2 swapPairs: "+ testListS); 
        System.out.println();
        
        // Exercise 10.6
        System.out.println(testListC);
        minToFront(testListC);
        minToFront(testListCempty);
        System.out.println("10.6 minToFront: " + testListC);
        System.out.println();
        
        // Exercise 10.7
        System.out.println(testListC);
        removeDuplicates(testListC);
        removeDuplicates(testListCempty);
        System.out.println("10.7 removeDuplicates: " + testListC);
        System.out.println();
        
        // Exercise 10.12
        System.out.println(testListS);
        markLength4(testListS);
        markLength4(testListSempty);
        System.out.println("10.12 markLength4: " + testListS);
        System.out.println();
    
        // Exercise 10.18
        System.out.println(testListS);
        mirror(testListS);
        mirror(testListSempty);
        System.out.println("10.18 mirror: " + testListS);
        System.out.println();
    }
    
    public static void swapPairs(ArrayList<String> arrayList) {
        // If the given ArrayList is empty, do nothing
        if (arrayList.size() == 0)
            return;
        String temp;

        // Swap the first item with the item after
        for(int i = 0; i < arrayList.size(); i+=2) {
            temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(i+1));
            arrayList.set(i + 1, temp);
        }
    }

    public static void minToFront(ArrayList<CalendarDate> arrayList) {
        // If the given ArrayList is empty, do nothing
        if (arrayList.size() == 0)
            return;
        CalendarDate minCalendar = arrayList.get(0);
        for(int i = 1; i < arrayList.size(); i++) {
            if(minCalendar.compareTo(arrayList.get(i)) > 0)
                minCalendar = arrayList.get(i);
        }
        arrayList.remove(minCalendar);
        arrayList.add(0, minCalendar);

    }

    public static void removeDuplicates(ArrayList<CalendarDate> arrayList) {
        // If the given ArrayList is empty, do nothing
        if (arrayList.size() == 0)
            return;
        CalendarDate currentCalendarDate = arrayList.get(0);
        for(int i = 1; i < arrayList.size(); i++) {
            if((currentCalendarDate.equals(arrayList.get(i))))
                arrayList.remove(i);
            else
                currentCalendarDate = arrayList.get(i);
        }
    }

    public static void markLength4(ArrayList<String> arrayList) {
        // If the given ArrayList is empty, do nothing
        if (arrayList.size() == 0)
            return;
        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).length() == 4) {
                arrayList.add(i, "****"); // Assign the current element and push the former current to the next
                i++; // Increment i to account for the added string
            }
        }
    }

    public static void mirror(ArrayList<String> arrayList) {
        // If the given ArrayList is empty, do nothing
        if (arrayList.size() == 0)
            return;
        int length = arrayList.size();
        for(int i = 0; i < length; i++) {
            arrayList.add(arrayList.get(length - 1 - i));
        }
    }
}