package aufgabe7;

public class QuickSort {

    public static <T extends Comparable<T>> void quickSort(T[] a, int left, int right) {
        if (left < right) {
            if (right - left <= 100) {
                InsertionSort.insertionSort(a, left, right + 1);
                return;
            }

            int pivot = partition(a, left, right);

            quickSort(a, left, pivot - 1);
            quickSort(a, pivot, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int left, int right) {
        T pivot;

        pivot = a[(left + right) / 2];
        while (left <= right) {
            while (a[left].compareTo(pivot) < 0)
                left++;

            while (right >= left && a[right].compareTo(pivot) > 0)
                right--;

            if (left <= right) {
                swap(a, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static <T extends Comparable<T>> void swap(T[] a, int first, int second) {
        T tmp = a[first];
        a[first] = a[second];
        a[second] = tmp;
    }

}
