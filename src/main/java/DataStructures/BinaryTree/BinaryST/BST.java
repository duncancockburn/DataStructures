package DataStructures.BinaryTree.BinaryST;



public class BST {
    private Node root;
    private int count = 0;


    /**
     * Adds item to the beginning of list
     *
     * @param the item to be added
     */


    public void insertDataInt(int data) {               //insert data, number
        root = insertDataInt(root, data);                 //passing the root node is pretty much the whole bst
    }

    /**
     * Adds integer into tree
     *
     * @param the item to be added
     * @param the root node
     * @return new node returned to public method above (recursion)
     */
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
 //       count++;
        return node;
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

//find a minimum value in the right subtree;
//replace value of the node to be removed with found minimum.
// Now, right subtree contains a duplicate;
//apply remove to the right subtree to remove a duplicate.


    public boolean deleteData(int data) {           //insert data, number
        if (root == null) {
            return false;
        } else return deleteData(findDataInt(data), data);
    }

    public boolean deleteData(Node node, int data) {
        if (data > root.getData()) {
            node = getMinRight(node, data);
        }else {
                node = getMaxLeft(node, data);
        }
        return true;
    }

    public Node getMaxLeft (Node node, int data) {
        Node maxLeft = root;
        if (node.getRight() == null) {
            node = maxLeft;
        }
        else getMaxLeft(node.getRight(), data);

        return maxLeft;
    }
    public Node getMinRight(Node node, int data) {
        Node minRight = root;
        if (node.getLeft() == null) {
            node = minRight;
        }
        else getMinRight(node.getLeft(), data);
    return minRight;
    }
}







