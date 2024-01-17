package Chapter_10_Quiz;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/16/24
 * Chapter 10 Quiz
 * Quiz 10 class
 */
import java.util.ArrayList;

public class Quiz10 {
    public static void main(String[] a147) {
        ArrayList<CalendarDate> dates = new ArrayList<CalendarDate>(674);
        dates.add(new CalendarDate(5, 5, 2018));
        dates.add(new CalendarDate(10, 5, 2018));
        dates.add(new CalendarDate(5, 7, 2017));
        dates.add(new CalendarDate(10, 5, 2020));
        System.out.println("Before: " + dates); // 4 items in list
        removeOddMonths(dates);
        System.out.println(" After: " + dates); // now fewer items
    }

    public static void removeOddMonths(ArrayList<CalendarDate> arrayList) {
        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i).getMonth() % 2 == 1) {
                arrayList.remove(i);
                i--;
            }
        }
    } 
    
}