package com.test.top.one.fifty;

public class HouseRobber_BestSolution {

    static void main() {
        HouseRobber_BestSolution houseRobber = new HouseRobber_BestSolution();
        System.out.println(houseRobber.rob(new int[]{1,1}));
    }

    public int rob(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }

        int first = nums[0];
        int second = nums[1];
        int previous = first;
        //2,1,1,2
        //2,1,3,2
        int max = Math.max(first,second);

        for (int i = 2; i < nums.length; i++) {
            int lastOne = nums[i] + first;
            int lastTwo = nums[i] + previous;
            previous = first;
            first = second;
            second = Math.max(lastOne, lastTwo);
            max = Math.max(max, second);
        }
        return max;

    }
}
