package Chapter_14;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 2/13/24
 * Chapter 14 exercises
 */

import java.util.LinkedList;
import java.util.Queue;

public class Chapter14 {
    public static Stack<CalendarDate> stutter(Stack<CalendarDate> stack) {

        Stack<CalendarDate> duplicatedStack = new Stack<>();
        Queue<CalendarDate> queue = new LinkedList<>();

        while (!stack.empty()) {
            CalendarDate element = stack.pop();
            duplicatedStack.push(element);
            duplicatedStack.push(element);
        }

        while (!duplicatedStack.empty()) {
            queue.offer(duplicatedStack.pop());
        }

        while (!queue.isEmpty()) {
            duplicatedStack.push(queue.poll());
        }

        return duplicatedStack;
    }

    public static boolean equals(Stack<CalendarDate> stack1, Stack<CalendarDate> stack2) {
        if (stack1.size() != stack2.size()) {
            return false;
        }

        Stack<CalendarDate> temp = new Stack<>();
        boolean isEqual = true;

        while (!stack1.empty()) {
            CalendarDate date1 = stack1.pop();
            CalendarDate date2 = stack2.pop();
            if (date1 != date2)
                isEqual = false;
            temp.push(date1);
            temp.push(date2);
        }

        while (!temp.empty()) {
            stack2.push(temp.pop());
            stack1.push(temp.pop());
        }

        return isEqual;
    }

    public static boolean isSorted(Stack<CalendarDate> s) {
        Stack<CalendarDate> tempStack = new Stack<>();
        boolean sorted = true;

        while (!s.empty()) {
            CalendarDate element = s.pop();
            if (!s.empty()) {
                CalendarDate elementPeek = s.peek();
                if (element.compareTo((elementPeek)) > 0)
                    sorted = false;
            }
            tempStack.push(element);
        }

        while (!tempStack.empty()) {
            s.push(tempStack.pop());
        }
        return sorted;
    }

    public static CalendarDate removeMin(Stack<CalendarDate> s) {
        Queue<CalendarDate> tempQueue = new LinkedList<>();
        CalendarDate minDate = s.peek();

        while (!s.empty()) {
            CalendarDate element = s.pop();
            if (element.compareTo(minDate) < 0)
                minDate = element;
            tempQueue.add(element);
        }

        while (!tempQueue.isEmpty()) {
            CalendarDate element = tempQueue.poll();
            if (element != minDate) {
                s.push(element);
            }
        }

        while (!s.empty() && s.peek() != minDate) {
            tempQueue.add(s.pop());
        }

        while (!tempQueue.isEmpty()) {
            s.push(tempQueue.poll());
        }

        return minDate;
    }

}
