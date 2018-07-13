package DataStructures.BinaryTree.BTSCompleted;

public class BinarySearchTreeImpl {

    private Node root;
    private int count = 0;
    private Node printLeft;
    private Node printRight;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public Node getRoot() {
        return this.root;
    }
    public Node findDataInt(int data) {               //insert data, number
        return findDataInt(root, data);
    }


    private Node findDataInt(Node node, int data) {
        if (node == null) {
            return node;
        } else if (node.getData() == data) {
            return node;
        } else if (node.getData() < data) {
            findDataInt(node.getLeft(), data);
        } else findDataInt(node.getRight(), data);
        return node;
    }


    //method to insert data into the binery tree.
    //states exactly what is to be input
    //if the root is empty then create a root by initialising and creating the object root passing in data
    //if the root is not empty then we will pass the information to the insertNode method
    public void insertDataInt(int data) {               //insert data, number
        root = insertDataInt(root, data);                 //passing the root node is pretty much the whole bst
    }
    private Node insertDataInt(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data <= node.getData()) {
                node.setLeft(insertDataInt(node.getLeft(), data));
            } else {
                node.setRight(insertDataInt(node.getRight(), data));
            }
        }
        count++;
        return node;
    }


    //method takes in the root and the data and returns a node.
    //if the root is bigger than the data then we go to the left
    //if the one to the left is empty then add the balance to the left


    public void delete(Integer data) {
        deleteNode(root, data);
    }


    private Node deleteNode(Node root, int data) {
        if (root == null){
            return root;}

        if (data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if (data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));


        } else {
            // node with no leaf nodes
            if (root.getLeft() == null && root.getRight() == null) {
                System.out.println("deleting " + data);
                return null;

            } else if (root.getLeft() == null) {
                // node with one node (no left node)
                System.out.println("deleting " + data);
                return root.getRight();
            } else if (root.getRight() == null) {
                // node with one node (no right node)
                System.out.println("deleting " + data);
                return root.getLeft();


            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                if (data < root.getData()) {
                    Integer maxValue = maxValue(root.getLeft());
                    root.setData(maxValue);
                    root.setRight(deleteNode(root.getRight(), maxValue));
                    System.out.println("deleting " + data);

                } else {
                    Integer minValue = minValue(root.getRight());
                    root.setData(minValue);
                    root.setLeft(deleteNode(root.getLeft(), minValue));
                    System.out.println("deleting " + data);
                }
            }
        }return root;
    }


    private Integer minValue (Node node){

        if (node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getData();
    }

    private Integer maxValue (Node node){

        if (node.getRight() != null) {
            return maxValue(node.getRight());
        }
        return node.getData();
    }



    //Inorder (Left, Root, Right)



    //Preorder (Root, Left, Right)














    public synchronized void preOrder(Node root){
        if (root == null){
            System.out.println(root.getData());
            return;}
            else {
            BinarySearchTreeImpl object = new BinarySearchTreeImpl();
            synchronized (this) {
                preOrder(object.printLeft);
                preOrder(object.printRight);
            }
        }
    }

    public Node printLeft(Node root){
        root = root.getLeft();
        System.out.println(root);
        return printLeft(root);
    }


    public Node printRight(Node root){
        root = root.getRight();
        System.out.println(root);
        return printRight(root);
    }
}