package DataStructures.HashMapCustomOnly;

public class HashMap<K, V> {

    //create a Node instance variable because each part of the index on the hashmap table will have linked lists in
    //which each element is called a node. (Need to create a node sublass to activate the next method in the custom Node
    //class which will be used when we resize the hashmap array

    //creating the initial size of the hash map. We need to create an empty has map of a defined size before starting
    //and before puting values into the hashmap
    private int INITIAL_SIZE = 3;

    //creating an array called table of pair objects. We need to create a subclass for Pair to define what is within a
    //pair to prevent having to define it over and over again
    private Pair<K, V>[] table;


    //need to create a constructor which lakes in the initial size of the array of objects
    public HashMap() {
        table = new Pair[INITIAL_SIZE];
    }


    //the add method vakes in a key and a value
    public void add(K key, V value) {

        // get hash code for key that we are adding in. By calling the hash method, it returns an integer for the table
        // index and this will be set to 'hash'
        int hash = hash(key);

        // need to check for any collisions. if there is nothing at the desired index in the table array then 'activate'
        //the start of the object created on line 16 by adding an object of type pair.
        if (table[hash] == null) {
            table[hash] = new Pair(key, value);

            //otherwise create the object p of the pair class. Need the object to call 'next' and use this to iterate
            // through collision list to the end
        } else {
            Pair<K, V> p = table[hash];
            //when p.next is null it means we are at the end of the list and thereforre can break and add object of type
            //pair
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Pair(key, value);
        }
        // Check for resize.
        // Calls the key method which combines all of the linked lists together
        // This method returns a big linked list of elements
        // This is the used to call and put through the size method to count the number of nodes.
        int a = size();
        if (a > table.length * .5) {
            resize();
        }
    }



    //resize method is used when there is more keys than .75 of the length of the hashmap. This is needed as if there
    //are too many keys with the same hash index then the time it takes for the system to itterate through a linked
    //list increases with data where as if the array is bigger the time increase less

    private void resize() {
        //takes the old array of pairs in the table
        Pair<K, V>[] old = table;
        //then redefine table array with double the number of indexes- ie double the size
        table = new Pair[old.length * 2];

        //for each pair object called c, we iterate this through the old table array and then pass each of the keys and
        // the values to the table array through the add method
        for (Pair<K, V> c : old) {
            // in case one array position is null, keep going over the array
            if (c != null) {
                // copying the array head
                add(c.getKey(), c.getValue());
                // copying the linkedList of each position in the array
                while (c.next != null) {
                    c = c.next;
                    add(c.getKey(), c.getValue());
                }
            }else{
                continue;
            }
        }
        System.out.println("resize has run");
    }


    public void remove(K key) {
        // ensure key exists
        if (find(key) == null) {
            return;
        }
        // get hash for key
        int hash = hash(key);
        Pair<K, V> p = table[hash];

        if (p.getKey() == key) {
            table[hash] = p.next;
        } else {
            // iterate through collision list while the next object isnt empty and while the key isnt found
            while (p.next != null && p.next.getKey() != key) {
                p = p.next;
            }
            //break when the key is found in which case make the object = null to remove
            p.next = p.next.next;
        }
    }


    public V find(K key) {
        // get hash for key
        int hash = hash(key);
        // nothing at key
        if (table[hash] == null) {
            return null;
        }
        // iterate through collision list
        Pair<K, V> p = table[hash];
        while (p.getKey() != key) {
            // no more entries
            if (p.next == null) {
                return null;
            }
            // move to next
            p = p.next;
        }

        // key found and return the value of the key
        return p.getValue();
    }


    //size method to work out the size of a linked list
    public int size() {
        int count = 0;

        for(int i = 0; i<table.length; i++){
            if(table[i] != null){
                count++;
            }
        }
        return count;
    }


    //hash method which gets the hashcode and then divides this by the table length giving the remainder used as index
    private int hash(K key) {
        int k = Math.abs(key.hashCode() % table.length);
        return k;
    }


    //need a method which returns the length of the array so that we can check the length of the hashmap in the main
    //method

    public int getStorage() {
        return table.length;
    }





//need to define what a pair is and use this to suggest that a pair points to the next item
    private class Pair<K, V> {
        private K key;
        private V value;
        Pair next = null;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

    }


}

