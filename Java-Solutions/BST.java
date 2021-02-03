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

    void inOrder(){
        inOrderRec(root);
    }

    // Printing recursive
    void inOrderRec(Node root){
        if(root != null){
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }

    }

    public static void main(String[] args) {
        BST tree = new BST();

        tree.insertData(50); 
        tree.insertData(30); 
        tree.insertData(20); 
        tree.insertData(40); 
        tree.insertData(70); 
        tree.insertData(60); 
        tree.insertData(80);

        System.out.print("Binary tree : ");
        tree.inOrder();
        System.out.println();

        System.out.print("\nAfter deleting 20 : ");
        tree.deleteNode(20);
        tree.inOrder();

        System.out.print("\nAfter deleting 30 : ");
        tree.deleteNode(30);
        tree.inOrder();

        System.out.print("\nAfter deleting 50 : ");
        tree.deleteNode(50);
        tree.inOrder();
    }

}
