package DataStructures.HashMapCustom;

public class LinkedList<T> {

    Node firstNode;


    public LinkedList(T... data) {           //put in 3 strings- create an array of the 3

        if (data.length < 1) {
            firstNode = null;
        } else {
            for (int i = 0; i < data.length; i++) {
                append(data[i]);
            }
        }
    }


    public void append(T data) {

        if (firstNode == null) {
            firstNode = new Node(data);
            return;
        }

        Node current = firstNode;

        while (current.next != null) {
            current = current.next;
        }
        current = new Node(data);
    }




    public void prepend(T data) {
        if (firstNode == null) {
            firstNode = new Node(data);
        }                     //if firstNode = null then create a new node

        Node newHead = new Node(data);              //if firstNode is not empty then create a new note
        newHead.next = firstNode;                        //the new firstNode which has been created- next is the firstNode
        firstNode = newHead;                             //replace the old firstNode with the new one
    }



    public void delete(T data) {
        if (firstNode == null) {
            return;
        } else if (firstNode.data == data) {
            firstNode = null;
        }

        Node current = firstNode;

        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }


    public void printList() {
        if (firstNode == null) {
            return;
        }
        Node current = firstNode;
        boolean more = true;

        while (more) {
            System.out.println(current.toString());
            if (current.next == null) {
                return;
            }
            current = current.next;
        }
    }

    public int size() {
        int count = 0;
        Node iterator = firstNode;

        // iterate through list
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }

        return count;
    }


    class Node {
        T data;                     //the data
        Node next;                  //the node just points to the next item

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node node) {
            this.data = data;
            this.next = node;

        }
    }
}


