package Chapter_11_Quiz;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/23/24
 * Chapter 11 Quiz
 * Quiz 11 class
 */
import java.util.*;
// Iverson's starter code:
// copyright 2024 Bellevue College
public class Quiz11 {
    public static void main(String[] args331) {
        ArrayList<CalendarDate> list1 = new ArrayList<CalendarDate>(690);
        System.out.println(yearMode(list1)); //   0 is returned when list is empty
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(1, 2, 2018));
        list1.add(new CalendarDate(5, 5, 2018));
        list1.add(new CalendarDate(10, 7, 1907));
        list1.add(new CalendarDate(5, 5, 2018));
        System.out.println(yearMode(list1)); //   4 times we have the year 2018
    }

    // solutions go below here:
    public static int yearMode(List<CalendarDate> quiz) {
    if(quiz.size() == 0)
        return 0;

    CalendarDate currentKey;
    int maxKey = 0;
    int maxKeyOccurrences = 0;    
    Iterator<CalendarDate> s = quiz.iterator();
    Map<Integer, Integer> map = new HashMap<>();

    while(s.hasNext()) {
        currentKey = s.next();
        if(map.containsKey(currentKey.getYear()))
            map.put(currentKey.getYear(), map.get(currentKey.getYear()) + 1);
        else
            map.put(currentKey.getYear(), 1);
        if(map.get(currentKey.getYear()) > maxKeyOccurrences) {
            maxKey = currentKey.getYear();
            maxKeyOccurrences = map.get(maxKey);
        }
    }

    return maxKeyOccurrences;

    }
}
