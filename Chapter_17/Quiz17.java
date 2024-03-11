// NO imports allowed as IntTree is just int data
// copyright 2024 Bellevue College
public class Quiz17 {
 public static void main(String[] arg240) {
        IntTreeNode one = new IntTreeNode(0,null,null);    
        IntTreeNode two = new IntTreeNode(0,null,null);        
        two = new IntTreeNode(2*240,null,new IntTreeNode(9,null,new IntTreeNode(0,null,null)));
        one = new IntTreeNode(1,new IntTreeNode(8,new IntTreeNode(7,null,null),null),two);        
        
        IntTree quiz17 = new IntTree(one); 
        IntTree quiz170 = new IntTree(170);
  
        System.out.println(quiz170);
        System.out.println("---------------------------");
        quiz170.removeEvenNumbers();
        System.out.println(quiz170);
        
        // Some other trees to test
        //IntTree quiz17zero = new IntTree();
        //IntTree quiz170 = new IntTree(170);
        }
 } // your solution is in IntTree.java
