package t1_simple;

/**
 * InsertionSortCode
 *
 * @author cmz
 * @date 2021-05-20 22:08
 */
public class InsertionSortCode {


    public static void insertionSort(int arr[]) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }


}
