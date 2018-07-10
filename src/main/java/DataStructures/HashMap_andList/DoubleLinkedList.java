package DataStructures.HashMap_andList;

public class DoubleLinkedList<T> {
        private Node startNode;

        public DoubleLinkedList(T ... data) {           //put in 3 strings- create an array of the 3

            if (data.length < 1) {
                startNode = null;
            } else {
                for (int i = 0; i < data.length; i++) {
                    add(data[i]);
                }
            }
        }

        /**
         * Adds a new Node the given data to the end of the list
         * @param data to be added
         */
        public void add(T data) {
            insert(data, size());
        }

        /**
         * Inserts a new Node with the given data at the given index
         * @param data to be added
         * @param index to put the Node
         */
        public void insert(T data, int index) {
            // create new root node
            if (startNode == null) {
                startNode = new Node(data);
            } else {
                Node currentNode = startNode;

                // insert new node in front
                if (index == 0) {
                    startNode = new Node(data, startNode);
                }
                else {
                    // firstNode through list to find last node
                    while (currentNode.next != null) {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = new Node(data);
                }
            }
        }

        /**
         * Removes the Node at the given index
         * @param index to put the Node
         */
        public void remove(int index) {
            if (index == 0) {
                startNode = startNode.next;
            } else {
                try {
                    int count = 0;
                    Node previous = null;
                    Node firstNode = startNode;

                    // iterate until index is reached
                    while (count != index) {
                        previous = firstNode;
                        firstNode = firstNode.next;
                        count++;
                    }

                    // link previous node to the node after the current
                    previous.next = firstNode.next;

                } catch (NullPointerException ex) {
                    System.out.println("invalid index");
                }
            }
        }


        /**
         * Returns the value at the given index
         * @param index to get the value
         * @return the value at the index
         */
        public T get(int index) {
            try {
                int count = 0;
                Node currentNode = startNode;

                // iterate until index is reach
                while (count != index) {
                    currentNode = currentNode.next;
                    count++;
                }
                return currentNode.data;

            } catch (NullPointerException ex) {
                return null; // list is empty
            }
        }

        /**
         * Sets the value of the given index to the given data
         * @param index to put the data
         * @param data to be set
         */
        public void set(int index, T data) {
            try {
                int count = 0;
                Node iterator = startNode;


                // iterate through list
                while (count != index) {
                    iterator = iterator.next;
                    count++;
                }

                // change data
                iterator.data = data;

            } catch (NullPointerException ex) {
                System.out.println("invalid index");
            }
        }

        /**
         * Determines the size of the list
         * @return an Integer size
         */
        public int size() {
            int count = 0;
            Node iterator = startNode;

            // iterate through list
            while (iterator != null) {
                count++;
                iterator = iterator.next;
            }

            return count;
        }

        /**
         * Converts the list into a String
         * @return a human readable String
         */
        public String toString() {
            Node iterator = startNode;
            String output = "";

            // iterate through list
            while (iterator != null) {
                output += iterator.data + " ";
                iterator = iterator.next;
            }

            return output;
        }


        /**
         * A Node of a Linked List
         */
        private class Node {
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

