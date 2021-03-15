class Node1 {
    int key, height;
    Node1 left, right;
 
    Node1(int d) {
        key = d;
        height = 1;
    }
}
 
class AVLTree {
 
    Node1 root;
 
    // A utility function to get the height of the tree
    int height(Node1 N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
 
    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
 
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node1 rightRotate(Node1 y) {
        Node1 x = y.left;
        Node1 T2 = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = T2;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node1 leftRotate(Node1 x) {
        Node1 y = x.right;
        Node1 T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node1 N
    int getBalance(Node1 N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
 
    Node1 insert(Node1 node1, int key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node1 == null)
            return (new Node1(key));
 
        if (key < node1.key)
            node1.left = insert(node1.left, key);
        else if (key > node1.key)
            node1.right = insert(node1.right, key);
        else // Duplicate keys not allowed
            return node1;
 
        /* 2. Update height of this ancestor node1 */
        node1.height = 1 + max(height(node1.left),
                              height(node1.right));
 
        /* 3. Get the balance factor of this ancestor
              node1 to check whether this node1 became
              unbalanced */
        int balance = getBalance(node1);
 
        // If this node1 becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node1.left.key)
            return rightRotate(node1);
 
        // Right Right Case
        if (balance < -1 && key > node1.right.key)
            return leftRotate(node1);
 
        // Left Right Case
        if (balance > 1 && key > node1.left.key) {
            node1.left = leftRotate(node1.left);
            return rightRotate(node1);
        }
 
        // Right Left Case
        if (balance < -1 && key < node1.right.key) {
            node1.right = rightRotate(node1.right);
            return leftRotate(node1);
        }
 
        /* return the (unchanged) node1 pointer */
        return node1;
    }
 
    // A utility function to print preorder traversal
    // of the tree.
    // The function also prints height of every node1
    void preOrder(Node1 node1) {
        if (node1 != null) {
            
            preOrder(node1.left);
            System.out.print(node1.key + " ");
            preOrder(node1.right);
        }
    }
 
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 14);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 35);
        tree.root = tree.insert(tree.root, 40);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        tree.preOrder(tree.root);
    }
}