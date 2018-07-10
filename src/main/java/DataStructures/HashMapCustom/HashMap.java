package DataStructures.HashMapCustom;

public class HashMap<K, V> {

    private int INITIAL_SIZE = 10;          //creating the initial size of the hash map
    private Pair<K, V>[] table;             //creating an array of pairs ie the hashmap


    public HashMap() {
        table = new Pair[INITIAL_SIZE];     //this is a constructor which sets in the initial size of the array of objects
    }


    public void add(K key, V value) {
        int hash = hash(key);                           // get hash code for key. From the hashcode it will then
        // give you the modulas ie the total divided by the number

        if (table[hash] == null) {                      // no collision yet
            table[hash] = new Pair(key, value);
        } else {                                           // iterate through collision list
            Pair<K, V> p = table[hash];                  //create the object p

            while (p.next != null) {                    // move to end
                p = p.next;
            }

            p.next = new Pair(key, value);              // add new pair
        }


        if (keys().size() > table.length * .075) {       // check for resize. takes all of the values and puts them together in a list. this is them put through the size method
            resize();
        }
    }


    private void resize() {
        Pair<K, V>[] old = table;
        table = new Pair[old.length * 2];

        for (Pair<K, V> c : old) {
            add(c.getKey(), c.getValue());
            while (c.next != null) {
                c = c.next;
                add(c.getKey(), c.getValue());
            }
        }
    }


    public void remove(K key) {
        if (find(key) == null) {                             // ensure key exists
            return;
        }
        int hash = hash(key);                               // get hash for key
        Pair<K, V> p = table[hash];// iterate through collision list

        if (p.getKey() == key) {
            table[hash] = p.next;
        } else {
            while (p.next != null && p.next.getKey() != key) {  // move to key
                p = p.next;
            }
            p.next = null;                                      // remove pair
        }
    }


    public V find(K key) {
        int hash = hash(key);                                // get hash for key
        if (table[hash] == null) {                          // nothing at key
            return null;
        }
        Pair<K, V> p = table[hash];                          // iterate through collision list
        while (p.getKey() != key) {
            if (p.next == null) {                           // no more entries
                return null;
            }
            p = p.next;                                     // move to next
        }
        return p.getValue();                                // key found
    }


    public LinkedList<K> keys() {
        LinkedList<K> keysLL = new LinkedList();
        for (int i = 0; i < table.length; i++) {                    // iterate through rows in the table array
            Pair<K, V> p = table[i];                             // iterate through columns
            while (p != null) {
                p = p.next;
            }
        }
        return keysLL;                          //returns a linked list
    }



    private int hash(K key) {
        int k = Math.abs(key.hashCode() % table.length);
        return k;
    }

    public int getStorage() {
        return table.length;
    }



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
