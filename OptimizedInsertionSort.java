public class OptimizedInsertionSort {

    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements that are greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            if (j + 1 != i) {   // optimization: avoid unnecessary assignment
                arr[j + 1] = key;
            }
        }
    }

    static void printArray(int[] arr) {
        for (int n : arr)
            System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 4, 3};

        System.out.print("Before sorting: ");
        printArray(arr);

        insertionSort(arr);

        System.out.print("After sorting:  ");
        printArray(arr);
    }
}
