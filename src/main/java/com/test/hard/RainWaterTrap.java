package com.test.hard;


public class RainWaterTrap {


    static void main() {

        RainWaterTrap rainWater = new RainWaterTrap();
        rainWater.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}); // 6
         rainWater.trap(new int[]{4,3,3,9,3,0,9,2,8,3});//23
         rainWater.trap(new int[]{1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 983, 982, 981, 980, 979, 978, 977, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966,              966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966});
         rainWater.trap(new int[]{8, 1, 7, 1, 6, 1, 5});
         rainWater.trap(new int[]{4,2,0,3,2,5});// 9
         rainWater.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3}); //83
        rainWater.trap(new int[]{5,4,1,2});//1
        rainWater.trap(new int[]{9, 6, 8, 8, 5, 6, 3});//3
    }



    public int trap(int[] height) {
        int prefix = 0;
        if (height.length == 1) {
            return 0;
        }
        int maxHeightLeft = height[0];
        int maxHeightRight = height[1];
        int previousLeftIndex = 0;
        int previousRightIndex = 1;
        int maxRightIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= maxHeightLeft && i < height.length - 1) {
                previousLeftIndex = i;
                previousRightIndex = i + 1;
                maxRightIndex = i + 1;
                maxHeightLeft = height[i];
                maxHeightRight = height[i + 1];
            } else {
                previousRightIndex = i;

                if (height[i] >= maxHeightRight) {
                    maxRightIndex = i;
                    maxHeightRight = height[i];
                }
                if (i < height.length - 1) {
                    prefix += maxHeightLeft - height[i];
                }
            }

        }

        if (maxHeightRight < maxHeightLeft) {
            for (int i = previousLeftIndex + 1; i < maxRightIndex; i++) {
                if (maxHeightRight >= height[i])
                    prefix = (prefix - (maxHeightLeft - height[i])) + maxHeightRight - height[i];
            }
            if(maxRightIndex < previousRightIndex)
                prefix = prefix - (maxHeightLeft - height[maxRightIndex]);
            for (int i = maxRightIndex+1; i < previousRightIndex; i++) {
                    prefix = prefix - (maxHeightLeft - height[i]);
            }
            if(previousRightIndex > maxRightIndex) {
                int revMaxHeightRight = height[previousRightIndex];
                int revMaxHeightLeft = height[previousRightIndex - 1];
                for (int i = previousRightIndex - 1; i > maxRightIndex; i--) {
                    if (height[i] >= revMaxHeightRight) {
                        revMaxHeightRight = height[i];
                        revMaxHeightLeft = height[i - 1];
                    } else {
                        if (height[i] >= revMaxHeightLeft) {
                            revMaxHeightLeft = height[i];
                        }
                        prefix += revMaxHeightRight - height[i];
                    }

                }
            }
        }

        System.out.println(prefix);
        return prefix;

    }
}
