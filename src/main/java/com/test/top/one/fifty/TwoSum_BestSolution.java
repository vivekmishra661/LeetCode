package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TwoSum_BestSolution {

    static void main() {
        TwoSum_BestSolution t = new TwoSum_BestSolution();
        var t1  = t.twoSum(new int[]{3,24,50,79,88,150,345}, 200);
    }

    public int[] twoSum(int[] numbers, int target) {
        int lowIndex = 0;
        int highIndex = 1;
        boolean found = false;
        while(!found) {
            if (numbers[lowIndex] + numbers[highIndex] < target) {

                if (highIndex < numbers.length-1) {
                    highIndex++;
                    if(target -numbers[highIndex] > numbers[lowIndex] && lowIndex< highIndex-1){
                        lowIndex++;
                    }
                }else{
                    lowIndex++;
                }
            } else if (numbers[lowIndex] + numbers[highIndex] > target) {
                if (lowIndex > 0) {
                    lowIndex--;
                    if(target -numbers[lowIndex] < numbers[highIndex] && highIndex> lowIndex+1){
                        highIndex--;
                    }
                }else{
                    highIndex--;
                }
            } else {
                found = true;
            }
        }
            return new int[]{lowIndex + 1, highIndex + 1};
    }


}
