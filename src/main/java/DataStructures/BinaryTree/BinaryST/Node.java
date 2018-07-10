package DataStructures.BinaryTree.BinaryST;

public class Node {
    private Node left;
    private Node right;
    private int data;
    private Node minLeft;
    private Node maxRight;

    public Node(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getMinLeft() {
        return minLeft;
    }

    public void setMinLeft(Node minLeft) {
        this.minLeft = minLeft;
    }

    public Node getMaxRight() {
        return maxRight;
    }

    public void setMaxRight(Node maxRight) {
        this.maxRight = maxRight;
    }
}