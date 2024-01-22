import java.util.*;
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 1/14/24
 * Chapter 11
 * Exercises for Chapter 11
 */
public class Exercises11
{
    public static void main(String[] a) {
        // Build Integer array
        Integer[] arrayI = {7,4,-9,4,15,8,27,7,11,-5,32,-9,-9};
        ArrayList<Integer> testListI = new ArrayList<Integer>();
        
        // Build an array of Strings
        String[] arrayS = {"Jane","Logan","Whitaker","Alyssa","Stefanie","Jeff","Kim","Sylvia"};
        ArrayList<String> testListS = new ArrayList<String>();
        
        // Build the Set of Strings:
        for (String s: arrayS) testListS.add(s);
        Set<String> testSetS = new TreeSet<String>(testListS);
        
        // Build the Set of Integers:
         Set<Integer> testSetI = new TreeSet<Integer>();       
        for (int i: arrayI) testSetI.add(i);
        
        // Build a Map of Strings:
        Map<String, String> testMapSS = new HashMap<String, String>();
        Map<String, Integer> testMapSI = new HashMap<String, Integer>();
        String[] array2 = {"Jane2","Logan2","Whitaker2","Alyssa2","Stefanie2","Jeff2","Kim2","Sylvia2"};
        for (int i=0; i<arrayS.length; i++) testMapSS.put(arrayS[i], array2[i]);
        for (int i=0; i<arrayS.length; i++) testMapSI.put(arrayS[i], i);
         
        // Exercise 11.8
        // System.out.println(testSetS);
        // System.out.println("maxLength="+maxLength(testSetS));       
        
        // Exercise 11.11 (text pg 759)
        // System.out.println(testSetI);
        // //System.out.println("symmetricSetDifference="+symmetricSetDifference(testSetI,testSetI));
        
        // // Exercise 11.12
        // System.out.println(testListS);
        // //System.out.println("contains3="+contains3(testListS));
        
        // // Exercise 11.13
        // System.out.println(testMapSS);
        // //System.out.println("isUnique="+isUnique(testMapSS));
        
        // // Exercise 11.14
        // System.out.println(testMapSI);
        // //System.out.println("intersect="+intersect(testMapSI,testMapSI));
        
        // // Exercise 11.15
        // System.out.println(testListI);
        // //System.out.println("maxOccurrences="+maxOccurrences(testListI));
    }

    public static int maxLength(Set<String> set) {
        if(set.size() == 0)
            return 0;
        int longestLen = 0;
        Iterator<String> s = set.iterator();
        String currentString;
        while(s.hasNext()) {
            currentString = s.next();
            if(currentString.length() > longestLen)
                longestLen = currentString.length();
        }
        return longestLen;
    }

    public static Set<Object> symmetricSetDifference(Set<Object> set1, Set<Object> set2) {
        Set<Object> returnSet = Collections.<Object>emptySet();
        Iterator<Object> s = set1.iterator();
        Object currentKey;
        while(s.hasNext()) {
            currentKey = s.next();
            if(!(set2.contains(currentKey))) {
                returnSet.add(currentKey);
            }
        }
        return returnSet;
    }

    public static boolean contains3(List<String> list) {
        if(list.size() == 0)
            return false;
        Map<String, Integer> map = new HashMap<String, Integer>();
        Iterator<String> s = list.iterator();
        String currentKey;
        while(s.hasNext()) {
            currentKey = s.next();
            if(map.containsKey(currentKey)) {
                map.put(currentKey, map.get(currentKey) + 1);
                if(map.get(currentKey) == 3) {
                    return true;
                }
            }
            else {
                map.put(currentKey, 0);
            }
        }
        return false;
    }

    public static boolean isUnique(Map<String, String> map) {
        if(map.size() == 0)
            return false;
        ArrayList<String> a = new ArrayList<String>();
        for(String value : map.values()) {
            if(a.contains(value))
                return false;
            else
                a.add(value);
        }
        return true;
    }

    public static Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> returnMap = new HashMap<String, Integer>();
        ArrayList<String> a = new ArrayList<String>();
        for(String key : map1.keySet()) {
            if(a.contains(key))
                continue;
            else
                a.add(key);
        }

        for(String key : map2.keySet()) {
            if(a.contains(key)) 
                continue;
            else
                a.remove(key);
        }

        for(String key : a) {
            if(map1.get(key).equals(map2.get(key))) {
                returnMap.put(key, map1.get(key));
            }
        }

        return returnMap;
    }

    public static int maxOccurrences(List<Integer> list) {
        if(list.size() == 0)
            return 0;
        Integer currentKey;
        Integer maxKey = 0;
        Integer maxKeyOccurences = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Iterator<Integer> s = list.iterator();

        while(s.hasNext()) {
            currentKey = s.next();
            if(map.containsKey(currentKey))
                map.put(currentKey, map.get(currentKey) + 1);
            else
                map.put(currentKey, 0);
            if(map.get(currentKey) > maxKeyOccurences) {
                maxKey = currentKey;
                maxKeyOccurences = map.get(currentKey);
            }
        }

        return maxKey;
    }

}