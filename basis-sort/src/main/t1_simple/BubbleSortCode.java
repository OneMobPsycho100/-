package t1_simple;

/**
 * BubbleSortCode
 *
 * @author cmz
 * @date 2021-05-20 22:02
 */
public class BubbleSortCode {


    public static void bubbleSort(int arr[]) {

        if (arr == null || arr.length < 2) {
            return;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int tmp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = tmp;
    }


}
