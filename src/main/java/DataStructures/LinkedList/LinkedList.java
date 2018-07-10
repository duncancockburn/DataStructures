package DataStructures.LinkedList;

public class LinkedList {
    public Node head;
    public int listCount;

    public LinkedList() {
        head = new Node(0);
        listCount = 0;
    }



    public void find() {
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println(current.data);
    }



    public boolean add(int data) {
        Node end = new Node(data);
        Node current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = end;
        listCount++;
        System.out.println(data + " appended to tail!");
        return true;
    }


    public boolean add(int data, int index) {
        Node end = new Node(data);
        Node current = head;
        int nodeIterator;

        if (index > listCount || index < 1) {
            System.out.println("Add Failed: index out of bounds of size of linked list!!");
            return false;
        } else {
            nodeIterator = 0;
            while (nodeIterator < index - 1) {
                current = current.next;
                nodeIterator++;
            }
            end.next = current.next;
            current.next = end;
            listCount++;
            System.out.println("Success! " + data + " added at index " + index);
            return true;
        }
    }



    public boolean deleteNodeWithData(int data) {
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                listCount--;
                System.out.println("Success! Node with data " + data + " deleted.");
                return true;
            }
            current = current.next;
        }
        System.out.println("Delete Failed: No node found with given data!");
        return false;
    }



    public boolean deleteNodeAtIndex(int index) {
        Node current = head;
        int nodeIterator;
        if (index > listCount || index < 1) {
            System.out.println("Delete Failed: index out of bounds of size of linked list!!");
            return false;
        } else {
            nodeIterator = 0;
            while (nodeIterator < index - 1) {
                current = current.next;
                nodeIterator++;
            }
            current.next = current.next.next;
            System.out.println("Success! Node at index " + index + " deleted.");
            listCount--;
            return true;
        }
    }
}