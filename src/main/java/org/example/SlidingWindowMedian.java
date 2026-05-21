package org.example;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMedian {

    static void main() {
        SlidingWindowMedian.test(new int[]{-2147483648,-2147483648,2147483647,-2147483648,1,3,-2147483648,-100,8,17,22,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 6);
    }

    public static void test(int[] nums, int k) {
        var queue1 = new PriorityQueue<Integer>((a, b) -> b - a);  // 5,4,3,2,1
        var queue2 = new PriorityQueue<Integer>((a, b) -> a - b);// 6,7,8,9,10
        double[] med = new double[nums.length-(k-1)];
        int i = 0;
        while (i < nums.length) {
            queue1.add(nums[i]);
            queue2.add(queue1.poll());
            if (queue1.size() < queue2.size()) {
                queue1.add(queue2.poll());
            }

            if (i >= k - 1 && (queue1.size()+ queue2.size()==k)) {
                med[i - (k - 1)] = k % 2 == 0 ? (new Double(queue1.peek()) + new Double(queue2.peek())) / new Double(2.0) : queue1.peek();
                if (queue1.contains(nums[i - (k - 1)])) {
                    queue1.remove(nums[i - (k - 1)]);
                } else {
                    queue2.remove(nums[i - (k - 1)]);
                }
                if (queue1.size() < queue2.size()) {
                    queue1.add(queue2.poll());
                }
            }
            i++;
        }
        Arrays.stream(med).forEach(System.out::println);

    }


}
