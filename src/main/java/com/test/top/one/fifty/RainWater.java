package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class RainWater {

    static void main() {
        RainWater rainWater = new RainWater();
        rainWater.trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3});
                //{3,9,7,8,8,7,9,3,5  });  //1-3, 3-6, 6-8
    }


    public int trap(int[] height) {



        List<Integer[]> k = new ArrayList<>();
        for (int i = 1; i < height.length - 1; i++) {
            int leftPointer = i - 1;
            int rightPointer = i + 1;
            int currentHeight = height[i];
            if (currentHeight > height[leftPointer] || currentHeight > height[rightPointer]) {
                continue;
            }
            while (true) {
                boolean shouldBreakLeft = false;
                boolean sholdBreakRight = false;
                if (leftPointer > 0 && height[leftPointer] <= height[leftPointer - 1]) {
                    leftPointer--;
                } else {
                    shouldBreakLeft = true;
                }
                if (rightPointer < height.length - 1 && height[rightPointer] <= height[rightPointer + 1]) {
                    rightPointer++;
                } else {
                    sholdBreakRight = true;
                }
                if (leftPointer == 0 && rightPointer == height.length - 1) {
                    shouldBreakLeft = true;
                    sholdBreakRight = true;
                }

                if (shouldBreakLeft && sholdBreakRight) {
                    break;
                }


            }
            var delta = Math.abs(leftPointer - rightPointer);
            if (currentHeight < height[leftPointer] && currentHeight < height[rightPointer] && delta >= 2) {
                int finalLeftPointer = leftPointer;
                int finalRightPointer = rightPointer;
                List<Integer> indexesToDelete = new ArrayList<>();
                k.add(new Integer[]{leftPointer, rightPointer});
                for(int j = k.size()-2; j>=0;j--){
                    Integer[] e=  k.get(j);
                    int firstIndex  = e[0];
                    int lastIndex = e[1];
                    if(firstIndex<= finalLeftPointer && height[firstIndex]>= height[finalLeftPointer] && height[lastIndex]<= height[finalRightPointer]){
                        e[1]= Math.max(lastIndex, finalRightPointer);
                        indexesToDelete.add(j+1);
                    }else if(firstIndex<= finalLeftPointer && lastIndex>= finalRightPointer && height[firstIndex]>= height[finalLeftPointer] && height[lastIndex]>= height[finalRightPointer]){
                        //delete entry;
                        indexesToDelete.add(j+1);
                    }
                    finalLeftPointer = e[0];
                    finalRightPointer = e[1];
                }
                if(!indexesToDelete.isEmpty()) {
                    List<Integer[]> t = new ArrayList<>();
                    for (int p = 0; p < k.size(); p++) {
                        if (indexesToDelete.contains(p)) {
                            continue;
                        } else {
                            t.add(k.get(p));
                        }
                    }
                    k = t;
                }

            }


        }

        int total = 0;
        for (var kp : k) {
            int lowerCircuit = Math.min(height[kp[0]], height[kp[1]]);
            for (int t = kp[0]; t <= kp[1]; t++) {
                if (height[t] < lowerCircuit)
                    total += lowerCircuit - height[t];
            }
        }

        System.out.println(total);
        return total;
    }



}
