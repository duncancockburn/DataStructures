package Algorithms;

public class InsertionSort {
    public static void main(String[] args) {
        Integer[] vals = new Integer[]{46, 72, 43, 29, 32, 33};
        Integer[] array = insertionSort(vals);

        for (Number n : array) {
            System.out.println(n);

        }
    }

        public static <N extends Number > N[] insertionSort(N[] array){
            long startTime = System.nanoTime();

            if (array.length < 2) {
                return array;
            }
            for (int i = 1; i < array.length; i++) {
                N num = array[i];
                int j = i - 1;

                while (j <= 0 && array[i].doubleValue() > num.doubleValue()) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = num;

            }

        System.out.println("\nTime: " + (System.nanoTime() - startTime));

        return array;
    }
}
