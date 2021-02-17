import java.util.Scanner;

// Shlok Zanwar
// Roll No.  :- 223071
// Gr No. :- 21910163

// 1.Implement binary search tree and perform following operations: a. Insert, Delete, Display 1 


public class BST {
    Node root;

    BST(){
        root = null;
    }

    // There are two methods for insertion (I have written both recursive and non recursive below)
    void insertData(int data){
        // root = insertRecursive(root, data);
        insertNonRec(data);
    }

    void deleteNode(int data){
        root = deleteRecursive(root, data);
    }

    // Deleting recursively
    Node deleteRecursive(Node root, int data){
        if(root == null){
            System.out.println("    Node not found !!");
            return root;
        }

        if(data < root.data){
            root.left = deleteRecursive(root.left, data);
        }
        else if(data > root.data){
            root.right = deleteRecursive(root.right, data);
        }
        else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            root.data = findInorderSuccessor(root.right);
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    // finding the value of next inorder successor
    int findInorderSuccessor(Node root){
        int minValue = root.data;
        while(root.left != null){
            minValue = root.left.data;
            root = root.left;
        }

        return minValue;
    }

    // Inserting recursively
    Node insertRecursive(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data < root.data){
            root.left = insertRecursive(root.left, data);
        }
        else{
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    // Inserting non-recursively
    void insertNonRec(int data){
        Node tempRoot = root;

        if (root == null){
            root = new Node(data);
            return;
        }

        while (true){
            if(data < tempRoot.data){
                if(tempRoot.left == null){
                    tempRoot.left = new Node(data);
                    break;
                }
                else{
                    tempRoot = tempRoot.left;
                }
            }
            else{
                if(tempRoot.right == null){
                    tempRoot.right = new Node(data);
                    break;
                }
                else{
                    tempRoot = tempRoot.right;
                }
            }
        }
        
    }

    void printTree(int choice){
        if(choice == 3){
            inOrderRec(root);
        }
        else if(choice == 4){
            preOrderRec(root);
        }
        else{
            postOrderRec(root);
        }

        
    }

    // Printing recursive
    void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    void preOrderRec(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    void postOrderRec(Node root){
        if(root != null){
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        BST tree = new BST();

        // Direct Inputs ................

        // tree.insertData(50); 
        // tree.insertData(30); 
        // tree.insertData(20); 
        // tree.insertData(40); 
        // tree.insertData(70); 
        // tree.insertData(60); 
        // tree.insertData(80);

        // System.out.print("Binary tree : ");
        // tree.printTree(3);
        // System.out.println();

        // System.out.print("\nAfter deleting 20 : ");
        // tree.deleteNode(20);
        // tree.printTree(3);

        // System.out.print("\nAfter deleting 30 : ");
        // tree.deleteNode(30);
        // tree.printTree(3);

        // System.out.print("\nAfter deleting 50 : ");
        // tree.deleteNode(50);
        // tree.printTree(3);

        while(true){
            System.out.println("\n\nEnter the operration you want to perform :- ");
            System.out.println("1) Insert  ");
            System.out.println("2) Delete  ");
            System.out.println("3) Print Inorder ");
            System.out.println("4) Print Preorder ");
            System.out.println("5) Print PostOrder ");
            System.out.println("0) Exit  ");
            System.out.print("Choice : ");

            int choice = input.nextInt();

            if(choice == 0){
                System.out.print("    Tree (Inorder) : ");
                tree.printTree(3);
                System.out.println("\nThank You");
                System.exit(0);
            }
            else if (choice == 1){
                System.out.print("\n    Enter number :- ");
                int num = input.nextInt();
                tree.insertData(num);

                System.out.print("    Updated tree (Inorder) : ");
                tree.printTree(3);
            }
            else if (choice == 2){
                System.out.print("\n    Enter number :- ");
                int num = input.nextInt();
                tree.deleteNode(num);

                System.out.print("    Updated tree (Inorder) : ");
                tree.printTree(3);
            }
            else if (choice == 3){
                System.out.print("    Inorder :- ");
                tree.printTree(3);
            }
            else if (choice == 4){
                System.out.print("    Preorder :- ");
                tree.printTree(4);
            }
            else if (choice == 5){
                System.out.print("    Postorder :- ");
                tree.printTree(5);
            }
            


        }

        // input.close();
    }

}
