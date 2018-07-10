package DataStructures.HashMap_andList;

public class HashMap<K, V> {

            private int INITIAL_SIZE = 10;          //creating the initial size of the hash map
            private Pair<K, V>[] table;             //creating an array of pairs ie the hashmap



            public HashMap() {
                table = new Pair[INITIAL_SIZE];     //this is a constructor which sets in the initial size
            }


        /**
         * Adds the key-value pair to the hashmap
         * @param key a key Object
         * @param value a value Object
         */

        public void add(K key, V value) {
            int hash = hash(key);                           // get hash code for key. From the hashcode it will then
                                                            // give you the modulas ie the total divided by the number

            if (table[hash] == null) {                      // no collision yet
                table[hash] = new Pair(key, value);
            }

            else {                                           // iterate through collision list
                Pair<K,V> p = table[hash];

                while (p.next != null) {                    // move to end
                    p = p.next;
                }

                p.next = new Pair(key, value);              // add new pair
            }



            if (keys().size() > table.length * .75) {       // check for resize
                resize();
            }
        }




        /**
         * Resizes the underlying array to double its previous size and copies the old values into it
         */


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



        /**
         * Removes the pair at the given key from the hashmap
         * @param key of the pair to be removed
         */

        public void remove(K key) {

            if(find(key) == null) {                             // ensure key exists
                return;
            }

            int hash = hash(key);                               // get hash for key

            Pair<K,V> p = table[hash];                          // iterate through collision list

            while (p.next != null && p.next.getKey() != key) {  // move to key
                p = p.next;
            }
            p.next = null;                                      // remove pair
        }



        /**
         * Finds the value of a key
         * @param key to search for
         * @return value of the given key
         */

        public V find(K key) {
            int hash = hash(key);                                // get hash for key

            if (table[hash] == null) {                          // nothing at key
                return null;
            }


            Pair<K,V> p = table[hash];                          // iterate through collision list
            while (p.getKey() != key) {
                if (p.next == null) {                           // no more entries
                    return null;
                }
                p = p.next;                                     // move to next
            }

            return p.getValue();                                // key found
        }



        /**
         * Returns all the keys in the hashmap
         * @return a DoubleLinkedList of keys
         */
        public DoubleLinkedList<K> keys() {

            DoubleLinkedList<K> keysLL = new DoubleLinkedList();


            for (int i = 0; i < table.length; i++) {                    // iterate through rows

                    Pair<K,V> p = table[i];                             // iterate through columns

                    while (p != null) {                 //this is the same as above???
                        keysLL.add(p.getKey());
                        p = p.next;
                    }
            }
            return keysLL;
        }




        /**
         * Hashes the given key and returns a table index
         * @param key to be hashed
         * @return a table index
         */
        private int hash(K key) {
            int k = Math.abs(key.hashCode() % table.length);
            return k;
        }


        public int getStorage() {
            return table.length;
        }

        /**
         * A Key-Value Pair
         */
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
