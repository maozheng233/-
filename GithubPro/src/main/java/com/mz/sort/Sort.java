package com.mz.sort;

import java.util.Arrays;

/**
 * @author maozh
 */
public class Sort {
    /**
     *快速排序
     * @param nums 待排序数组
     * @param low 左边界
     * @param high 右边界
     *
     */
    public static void quickSort(int[] nums,int low,int high){
        if(low > high){
            return;
        }
        int i = low;
        int j = high;
        int base = nums[low];
        int t = 0;
        while(i < j){
            while(i < j && nums[j] >=base){
                // 右指针左移,一直到两个指针相遇,或者右指针指向的元素值小于base值
                j--;
            }
            while(i <j && nums[i] <= base){
                // 左指针右移,直到两指针相遇或者左指针指向的元素值大于base
                i++;
            }
            // 交换左指针和右指针指向的元素值
            t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        // 交换base和i=j处的元素值
        t = nums[i];
        nums[i] = base;
        nums[low] = t;
        // 左右两边继续排序
        quickSort(nums,low,i-1);
        quickSort(nums,j+1,high);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 3, 7, 8, 1, 5};
        quickSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
