class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {

    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a node
    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert(root.left, key);
        else if (key > root.key)
            root.right = insert(root.right, key);

        return root;
    }

    // Inorder traversal
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int value : values) {
            tree.root = tree.insert(tree.root, value);
        }

        System.out.println("Inorder traversal of BST:");
        tree.inorder(tree.root);
    }
}