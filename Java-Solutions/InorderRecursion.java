// import java.util.*;

// it is coming from InorderTraversal.java 

// class Node{
//     int data;
//     Node left, right;

//     public Node(int item){
//         data = item;
//         left = right = null;
//     }

// }


public class InorderRecursion {
    Node root; 
  
    InorderRecursion() 
    { 
        root = null; 
    } 
  
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        printPreorder(node.left); 
        System.out.print(node.data + " "); 
        printPreorder(node.right); 
        
        
    } 
  
    void printPreorder() {
         printPreorder(root); } 

    public static void main(String[] args) {
        InorderRecursion tree = new InorderRecursion();
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.printPreorder(); 
    }
}
