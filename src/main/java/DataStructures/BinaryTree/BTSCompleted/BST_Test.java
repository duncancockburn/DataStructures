package DataStructures.BinaryTree.BTSCompleted;

public class BST_Test {

    public static void main(String args[]) {

        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
        bst.insertDataInt(8);
        bst.insertDataInt(10);
        bst.insertDataInt(14);
        bst.insertDataInt(3);
        bst.insertDataInt(6);
        bst.insertDataInt(7);
        bst.insertDataInt(1);
        bst.insertDataInt(4);
        bst.insertDataInt(13);
        System.out.println("-------------------");
        System.out.println("In Order Traversal");
        bst.inOrderTraversal();
        System.out.println();
        bst.delete(13);
        bst.inOrderTraversal();
        System.out.println();
        bst.delete(14);
        bst.inOrderTraversal();
    }
}
