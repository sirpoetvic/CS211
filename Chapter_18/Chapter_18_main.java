public class Chapter_18_main {
    public static void main(String[] args) {
        java.util.HashSet<CalendarDate> test1 = new java.util.HashSet<CalendarDate>();
        java.util.HashSet<CalendarDate> test2 = new java.util.HashSet<CalendarDate>();
        System.out.println(test1.containsAll(test2));
        System.out.println(test1.equals(test2));
        System.out.println(test1.removeAll(test2));
        System.out.println(test1.retainAll(test2));
    }
}
