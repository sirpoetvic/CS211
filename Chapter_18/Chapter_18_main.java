public class Chapter_18_main {
    public static void main(String[] args) {
        HashSet<CalendarDate> test1 = new HashSet<CalendarDate>();
        HashSet<CalendarDate> test2 = new HashSet<CalendarDate>();

        test1.add(new CalendarDate(1, 1, 2021));
        test1.add(new CalendarDate(12, 12, 2016));
        test1.add(new CalendarDate(1, 5, 2023));
        test2.add(new CalendarDate(1, 5, 2023));
        test2.add(new CalendarDate(1, 5, 2023));

        System.out.println("Before cases:");
        System.out.println(test1.toString());
        System.out.println(test2.toString());
        System.out.println("------------------------------------------");

        System.out.println("1 contains all of 2:");
        System.out.println(test1.containsAll(test2));
        System.out.println("------------------------------------------");

        System.out.println("1 equals 2:");
        System.out.println(test1.equals(test2));
        System.out.println("------------------------------------------");

        System.out.println("1 before removing all 2 from 1:");
        System.out.println(test1);
        test1.removeAll(test2);
        System.out.println("1 after removing all 2 from 1:");
        System.out.println(test1);
        System.out.println("------------------------------------------");

        // Restore dates
        test1.add(new CalendarDate(1, 1, 2021));
        test1.add(new CalendarDate(12, 12, 2016));
        test1.add(new CalendarDate(1, 5, 2023));
        System.out.print("2: ");
        System.out.println(test2);

        System.out.print("1: ");
        System.out.println(test1);

        System.out.println("1 before removing all non-2 from 1:");
        System.out.println(test1);
        test1.retainAll(test2);
        System.out.println("1 after removing all non-2 from 1:");
        System.out.println(test1);
    }
}
