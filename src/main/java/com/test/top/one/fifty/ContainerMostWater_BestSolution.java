package com.test.top.one.fifty;

public class ContainerMostWater_BestSolution {

    static void main() {
        ContainerMostWater_BestSolution c = new ContainerMostWater_BestSolution();
        int s = c.maxArea(new int[]{1,2,3,1000,9});
        System.out.println(s);
    }

    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate width between the two pointers
            int width = right - left;

            // The height of the water is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);

            // Calculate current area and update max if needed
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer that limits the height
            // We want to find a potentially taller line to offset the decreasing width
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;

    }
}
