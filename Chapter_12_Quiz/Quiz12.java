package Chapter_12_Quiz;
public class Quiz12 {
    // copyright 2024 Bellevue College
       public static void main(String[] x453) {
          System.out.println(compress("bookkkkkeeper"));
          System.out.println(compress("String"));
          System.out.println(compress(""));
       }
     public static String compress(String str) {
        if(str.length() <= 1) {
            return str;
        }
        if(str.charAt(0) == str.charAt(1))
            return compress(str.substring(1));
        else
            return str.charAt(0) + compress(str.substring(1));
     }
}
