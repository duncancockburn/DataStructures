package DataStructures.HashMap_andList;

public class HashMapTest {

        static HashMap<String, Number> hashmap = new HashMap();                 //this creates an object of class hashmap
                                                                                // called hashmap
        public static void main(String[] args){

            hashmap.add("Apple", 2.5);
            System.out.println(hashmap.find("Apple"));

            hashmap.add("Avocado", 10.23464);
            System.out.println(hashmap.find("Avocado"));

            hashmap.add("Pear", 5);
            System.out.println(hashmap.find("Pear"));

            hashmap.add("Mango", 0);
            System.out.println(hashmap.find("Mango"));

            hashmap.add("Kiwi", 10);
            System.out.println(hashmap.find("Kiwi"));

            hashmap.add("Grapefruit", 1);
            hashmap.add("Banana", 2);
            hashmap.add("Pineapple", 7);
            hashmap.add("Coconut", 8);





            int size = hashmap.getStorage();                        //calls a method in the hashmap class. passes in what you want to remove
            System.out.println(size);

            hashmap.remove("Pear");
            hashmap.remove("Orange");

            size = hashmap.getStorage();
            System.out.println(size);
        }
    }

