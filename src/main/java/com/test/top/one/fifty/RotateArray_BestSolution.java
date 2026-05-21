package com.test.top.one.fifty;

import java.util.Arrays;

public class RotateArray_BestSolution {

    static void main() {
        rotateEasyBetter(new int[]{1,2,3,4,5,6,7}, 3); //-> 4,-1,2,3 -> 3,4,-1,2 ->
    }

    public static void rotateEasy(int[] nums, int kk) {

        var k = kk> nums.length? kk% nums.length: kk;
            int[] y = new int[nums.length];
            int p = 0;
            for (int i = nums.length - k; i < nums.length; i++) {
                y[p] = nums[i];
                p++;

            }
            for (int i = 0; i < nums.length - k; i++) {
                y[p] = nums[i];
                p++;
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = y[i];
            }
        Arrays.stream(nums).forEach(System.out::println);

    }

    public static void rotateEasyBetter(int[] nums, int kk) {
        var k = kk> nums.length? kk% nums.length: kk;
        for(int i =0; i< nums.length/2;i++){
            int x = nums[nums.length-1-i];
            nums[nums.length-1-i] = nums[i];
            nums[i]= x;
        }
        for(int i=0; i< k/2; i++){
            int x = nums[k-1-i];
            nums[k-1-i] = nums[i];
            nums[i]= x;
        }
        int len = nums.length-1;
        int z = k;
        for(int i=0; i< (nums.length-k)/2; i++){
            int x = nums[len];
            nums[len] = nums[z];
            nums[z]= x;
            z++;
            len--;
        }
        Arrays.stream(nums).forEach(System.out::println);
    }
}
