package DataStructures.BinaryTree.ThreadedBinaryTree;

public class DoubleThreadedBinaryTree {

    public static Node root;
    public static boolean directionLeft;
    public static boolean directionRight;

    public DoubleThreadedBinaryTree() {

        //create the dummy node
        root = new Node(Integer.MAX_VALUE);
        root.leftBit = 0;
        root.rightBit = 1;
        root.left = root.right = root;
    }

    public void preOrder() {
        //start from the left child of the dummy node
        Node current = root.left;
        //go to the left most node
        while (current.left != null) {
            System.out.println(current.left);

            current = current.left;
        }

        //now keep traversing the next preOrder successor and print it
        while (current != root) {
            System.out.print("  " + current.data);
        }
    }



    class Node {
        int data;
        int leftBit;
        int rightBit;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}