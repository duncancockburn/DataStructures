package DataStructures.LinkedList;

public class LLTest {

    public static void main(String[] args) {

        LinkedList object = new LinkedList();
        object.add(1);
        object.find();
        object.add(2);
        object.find();
        object.add(3);
        object.find();
        object.deleteNodeWithData(2);
        object.find();
        object.deleteNodeAtIndex(3);
        object.find();
        object.deleteNodeAtIndex(1);
        object.find();
    }
}
