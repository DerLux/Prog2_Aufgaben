package aufgabe7;

public class InsertionSort {

    public static <T extends Comparable<T>> void insertionSort(T[] a, int left, int right) {
        int i = left+1;
        while (i <= right) {
            int j = i;
            while (j > left && a[j - 1].compareTo(a[j]) > 0) {
                T tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
                j--;
            }
            i++;
        }
    }

}
