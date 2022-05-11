package aufgabe7;

public class DreiMedianStrategie {
    public static <T extends Comparable<T>> void quickSortMedian(T[] a, int left, int right) {
        if (left < right) {
            if (right - left <= 100) {
                InsertionSort.insertionSort(a, left, right + 1);
                return;
            }

            int pivot = partition(a, left, right);

            quickSortMedian(a, left, pivot - 1);
            quickSortMedian(a, pivot, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int left, int right) {
        int mid = (left + right) / 2;

        if (a[left].compareTo(a[right]) > 0)
            swap(a, left, right);
        if (a[mid].compareTo(a[right]) > 0)
            swap(a, mid, right);
        if (a[left].compareTo(a[mid]) > 0)
            swap(a, left, mid);

        T pivot = a[(left + right) / 2];

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
