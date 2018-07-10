package DataStructures.BinaryTree;

public class BinaryTree {

    // Root of Binary Tree
    private Node firstNode;

    // Constructors
    BinaryTree(int key) {
        firstNode = new Node(key);
    }

    BinaryTree() {
        firstNode = null;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.firstNode = new Node(1);
        tree.firstNode.left = new Node(2);
        tree.firstNode.right = new Node(3);
        tree.firstNode.left.left = new Node(4);
    }


    public static class Node {
        int key;
        Node left, right;


        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
}

