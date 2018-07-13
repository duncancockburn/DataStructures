package DataStructures;

// Java program to illustrate need
// of Synchronization

public class Counter{

    long count = 0;

    public synchronized void add(long value){               //add method which takes in the add values. add in int from 0-10
        this.count += value;                                //this count is therefore 1
        System.out.println(count);
    }
}

// The same Counter instance is passed to both of them in their constructor.
// The Counter.add() method is synchronized on the instance, because the add method is an instance method,
// and marked as synchronized.
// Therefore only one of the threads can call the add() method at a time.
// The other thread will wait until the first thread leaves the add() method, before it can execute the method itself.

class CounterThread extends Thread{
    public Counter counter;
    public CounterThread(Counter counter){                  //using a contructor to pass the info to the add method and reboot
        this.counter = counter;
    }
    public void run() {
        for(int i=0; i<10; i++){                            //i = 1
            counter.add(i);
        }
    }
}


class Example {
    public static void main(String[] args){
        Counter counterA = new Counter();
        Counter counterB = new Counter();//creates a counter object of Counter class
        Thread  threadA = new CounterThread(counterA);       //creates a couple of thread objects
        Thread  threadB = new CounterThread(counterB);

        threadA.start();                                    //use object A to call the built in start method
        threadB.start();
    }
}