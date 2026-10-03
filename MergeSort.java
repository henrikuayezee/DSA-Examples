import java.util.Arrays;

public class MergeSort {

    // Sorts the array in place using merge sort
    static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    // Recursively splits arr[left..right] into halves, sorts each, then merges them
    static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    // Merges the sorted halves arr[left..mid] and arr[mid+1..right]
    static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            // <= keeps equal elements in their original order (stable sort)
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy any remaining elements from the left half
        // (leftovers from the right half are already in place)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Before: " + Arrays.toString(numbers));
        mergeSort(numbers);
        System.out.println("After:  " + Arrays.toString(numbers));
    }
}
