package t1_simple;

import java.util.Arrays;

/**
 * Test
 *
 * @author cmz
 * @date 2021-05-20 22:01
 */
public class Test {

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] testArray = generateRandomArray(10, 40);
        System.out.println(Arrays.toString(testArray));
        // 选择排序
        //SelectionSortCode.selectionSort(testArray);
        // 冒泡排序
        // BubbleSortCode.bubbleSort(testArray);
        // 插入排序
        InsertionSortCode.insertionSort(testArray);
        System.out.println(Arrays.toString(testArray));

    }

}
