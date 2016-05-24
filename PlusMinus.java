package plusminus;
import plusminus.LinkedList.Iterator;
import plusminus.LinkedList.Node;
import java.io.*;
import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args) throws FileNotFoundException {

        // Create a new linked list
        LinkedList list = new LinkedList();

        // Create scanner to read text file
        Scanner s = new Scanner(new BufferedReader(new FileReader("in.txt")));
                
        // Populate list with tokens from text file
        while (s.hasNext()) {
            int num = Integer.parseInt(s.next());
            list.addNode(num);
        }
        
        // Recursively find sums of all possible combinations --> Print 'Yes' and exit if match is found
        recursiveSum(list, list.getHead(), 0, 0);
        
        // Otherwise, print 'No' if match not found
        System.out.println("No");
        
        // Exit program
        System.exit(0);
    }

    // Recursive algorithm to find sums --> Prints 'Yes' then exits if a match is found
    private static void recursiveSum(LinkedList list, Node currentNode, int left, int right) { 
        
        // If the current node is null
        if (currentNode == null) {
            
            // Create an iterator to iterate over the list
            Iterator iterator = list.getIterator();
            
            // While there is still another item in the list
            while (iterator.hasNext() == true) {
                
                // If the difference between the two subsets is equal to the current node’s value 
                if (left-right == iterator.getCurrent().data) {
                    
                    // Print 'Yes'
                    System.out.println("Yes");
                    
                    // Exit program
                    System.exit(0);
                }
                
                // Match not found --> iterate to the next item in list
                iterator.next();
            }
        }
        // Otherwise, perform a “pseudo” pre-order binary tree traversal
        else {
            
            // Recursively add each list item to the left (positive) subset
            recursiveSum(list, currentNode.next, left + currentNode.data, right);
            
            // Recursively add each list item to the right (negative) subset
            recursiveSum(list, currentNode.next, left, right + currentNode.data);
        } 
    }
}

/**********************
    LinkedList Class
***********************/
class LinkedList {
    
    //Attributes
    private Node head;

    // Constructor
    public LinkedList() {
        head = null;
    }

    //Adds node to end of linked list
    public void addNode(int data) {
        
        // If head is empty, create node at beginning of list
        if (head == null) {
            
            // Create new node
            head = new Node(data, null);
        }
        // Otherwise, create node at end of list
        else {
            
           // Begin at head
           Node temp = head;
           
           // Iterate until next node is null
           while(temp.next != null) {           
               temp = temp.next;
           }
           // Create new node
           temp.next = new Node(data, null);
        }
    }
    
    // Returns first node in list
    public Node getHead() {
        return head;
    }
    
    // Returns a linked list iterator
    public Iterator getIterator() {
        return new Iterator();
    }

    /********************
        Iterator Class
    *********************/
    class Iterator {
        
        // Attributes
        private Node currentNode;

        // Constructor
        public Iterator() {
            currentNode = head;
        }

        // Returns true if next node is not null
        public boolean hasNext() {
            return currentNode != null;
        }

        // Moves iterator to subsequent node
        public void next() {
            currentNode = currentNode.next;
        }
        
        // Get integer value in current node
        public Node getCurrent() {
            return currentNode;
        }
    }

    /*****************
        Node Class
    *****************/
    class Node {
        
        // Attributes
        int data;
        Node next;

        // Constructor
        public Node(int d, Node n) {
            data = d;
            next = n;
        }
    }
}