/* CS211 Fibonacci Class, for Chapter 12 Assignment
 * Bellevue College, W.P. Iverson, instructor
 * January 2024
 */

 /*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/27/24
 * Fibonacci Driver Class
 */
public class FibDriver {
    // copyright Bellevue College
    public static void main(String[] args) {
        Fibonacci test = new Fibonacci(42); // constructor overload
        //System.out.println(test.fibForLoop()); // Chapter 2 code not used this week 
        long time1 = System.currentTimeMillis();
        System.out.println(test.fibonacci()); // slow version in text
        long time2 = System.currentTimeMillis();
        System.out.println("slow version run time ms: " + (time2-time1));
        System.out.println();
        /*
         * After numerous tests, and analysis of code, and considerable thought:
         * I conclude that fibonacci() is very slow with Big-O complexity of O(2^N).
         * I have come to this conclusion because fibonacci has 2 recursive calls per 
         * "n". It reduces the problem size by 1 each time. 
         */
        time1 = System.currentTimeMillis();
        //System.out.println(test.bigFib()); // same as above, but use BigInteger
        System.out.println(test.bigFastFib()); // same as above, but MUCH faster
        time2 = System.currentTimeMillis();
        System.out.println("bigFastFib version run time ms: " + (time2-time1));
         /*
         * After numerous tests, and analysis of code, and considerable thought:
         * I conclude that bigFastFib() is very fast with Big-O complexity of O(N).
         * I have come to this conclusion because bigFastFib has 1 recursive call per "n".
         */
    }
}