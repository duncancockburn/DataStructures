package Algorithms;

public class BubbleSort {
    public void BubbleSort(int[] array) {

        int temp;
        int a;
        int b;

        for (a = 0; a < array.length; a++) {                //a, the outer loop, makes
            for (b = 0; b < array.length - 1 - a; b++) {
                if (array[b] > array[b + 1]) {
                    temp = array[b];
                    array[b] = array[b + 1];
                    array[b + 1] = temp;

                }
            }
        }
    }
}
