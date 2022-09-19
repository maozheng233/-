package com.mz.sort;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @author maozh
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 3, 7, 8, 1, 5};
        sortArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }


    /**
     *
     * @param arr 要排序的数组
     * @param left 左边界下标
     * @param right 右边界下标
     * @param temp 辅助数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //如果拆分到数组中只剩下一个元素,则返回
        if (left == right) {
            return;
        }
// 找到下次要拆分的中间值
        int mid = (left + right) / 2;
// 记录树左边的
        mergeSort(arr, left, mid, temp);
// 记录树右边的
        mergeSort(arr, mid + 1, right, temp);

// 合并两个区间
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                // 左边数组遍历到了尽头
                arr[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                // 右边数组遍历到了尽头
                arr[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                // 取较小值
                arr[k] = temp[i];
                i++;
            } else {
                // 取较小值
                arr[k] = temp[j];
                j++;
            }
        }
    }
}
