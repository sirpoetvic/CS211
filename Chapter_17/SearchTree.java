// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, Building Java Programs
//
// modified by W.P. Iverson, to not allow duplicates added
// added toString()
// Bellevue College, January 2021
/*
 * {Victor}
 * Winter 2023, C211, William Iverson
 * 3/4/24
 * Chapter 17 exercises
 */
import java.util.NoSuchElementException;


public class SearchTree<E extends Comparable<E>> {
    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }
    
    // WRITE ADDITIONAL METHODS HERE:
    public boolean isFull() {
    return isFull(overallRoot);
}

public boolean isFull(SearchTreeNode<E> root) {
    if (root == null)
        return true;
    else if(root.left == null && root.right != null) {
        return false;
    }
    else if (root.right == null && root.left != null) {
        return false;
    }
    else
        return isFull(root.left) && isFull(root.right);
     
}

public boolean equals2(SearchTree<E> other) {
    return equals2Help(overallRoot, other.overallRoot);
}

public boolean equals2Help(SearchTreeNode<E> node1, SearchTreeNode<E> node2) {
    if(node1 == null && node2 == null)
        return true;
    else if((node1 != null && node2 == null) || (node1 == null && node2 != null))
        return false;
   
    return (node1.data.equals(node2.data)) && equals2Help(node1.left, node2.left) 
        && equals2Help(node1.right, node2.right);
}

public void removeLeaves() {
        if (overallRoot == null) 
        return;
        if (overallRoot.left == null && overallRoot.right == null) {
            overallRoot = null;
            return;
        } 
        removeLeavesHelper(overallRoot);
    }

private void removeLeavesHelper( SearchTreeNode<E> node ) {
    if ( node == null ) return;

    SearchTreeNode<E> left = node.left;
    SearchTreeNode<E> right = node.right;

    if ( left != null && left.left == null && left.right == null ) node.left = null;
    if ( right != null && right.left == null && right.right == null ) node.right = null;

    removeLeavesHelper(node.left);
    removeLeavesHelper(node.right);
}
public void remove(E value) {
    overallRoot = remove(overallRoot, value);
}

private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
    if (root == null) {
        return null;
    } else if (root.data.compareTo(value) > 0) {
        root.left = remove(root.left, value);
    } else if (root.data.compareTo(value) < 0) {
        root.right = remove(root.right, value);
    } else {  // root.data == value; remove this node
        if (root.right == null) {
            return root.left;    // no R child; replace w/ L
        } else if (root.left == null) {
            return root.right;   // no L child; replace w/ R
        } else {
            // both children; replace w/ min from R
            root.data = getMin(root.right);
            root.right = remove(root.right, root.data);
        }
    }
    return root;
}

// Throws a NoSuchElementException if the tree is empty.
public E getMin() {
    if (overallRoot == null) {
        throw new NoSuchElementException();
    }
    return getMin(overallRoot);
}

private E getMin(SearchTreeNode<E> root) {
    if (root.left == null) {
        return root.data;
    } else {
        return getMin(root.left);
    }   
}
   
    
    
    
    
    
    
    
    
    
    
    
    

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) > 0) {
            root.left = add(root.left, value);
        } else if (root.data.compareTo(value) < 0) {
            root.right = add(root.right, value);
        }
        return root;
    }

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        return contains(overallRoot, value);
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        if (root == null) {
            return false;
        } else {
            int compare = value.compareTo(root.data);
            if (compare == 0) {
                return true;
            } else if (compare < 0) {
                return contains(root.left, value);
            } else {   // compare > 0
                return contains(root.right, value);
            }
        }
    }

    // post: prints the data of the tree, one per line
    public void print() {
        printInorder(overallRoot);
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }
    
    // toString() added by W.P. Iverson for simple console testing
    // since String is immutable, I've used StringBuilder
    public String toString() {
    	StringBuilder s = new StringBuilder();
    	toString(overallRoot, 0, s);
    	return s.toString();
    }
    
    // similar reverse in order traversal of tree as print sideways
    private void toString(SearchTreeNode<E> root, int level, StringBuilder s) {
        if (root != null) {
            toString(root.right, level + 1, s);
            String temp = new String(); // different for each node
            for (int i = 0; i < level; i++) {
            	temp += "    ";
            }
            s.append(temp + root.data + "\n"); // uses same String in recursions
            toString(root.left, level + 1, s);
        }
    }

    
    
    // a private inner Class for the search tree nodes
    // there is no use for such nodes outside of the SearchTree Class
    // so a private inner Class is appropriate in this case...
    private static class SearchTreeNode<E> {
        public E data;                   // data stored in this node
        public SearchTreeNode<E> left;   // left subtree
        public SearchTreeNode<E> right;  // right subtree

        // post: constructs a leaf node with given data
        public SearchTreeNode(E data) {
            this(data, null, null);
        }

        // post: constructs a node with the given data and links
        public SearchTreeNode(E data, SearchTreeNode<E> left,
                              SearchTreeNode<E> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
