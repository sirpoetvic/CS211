
public class Quiz15 {
    public static void main(String[] arg179) {
        ArrayIntList quiz15 = new ArrayIntList();
        quiz15.add(1);
        quiz15.add(8);
        quiz15.add(7);
        quiz15.add(2);
        quiz15.add(9);
        quiz15.add(18);
        quiz15.add(2 * 3);
        quiz15.add(0);

        System.out.println(quiz15);
        quiz15.removeEvenNumbers();
        System.out.println(quiz15);
    }

}