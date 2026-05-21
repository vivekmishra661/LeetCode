package com.test.top.one.fifty;

public class ClimbingStairs_BestSolution {

    static void main() {
        ClimbingStairs_BestSolution climbingStairs = new ClimbingStairs_BestSolution();
        climbingStairs.climbStairs(38);
    }

    public int climbStairs(int n) {
        int first = 1;
        int second = 2;
        if(n<3) return n;
        for (int i = 3; i <= n; i++) {
           int third = first+second;
           first = second;
           second = third;
        }
        return second;
    }

    /*public int climbStairs(int n) {

        HashMap<Integer, Integer> step = new HashMap<>();
        recur(n, step);

        return step.get(0);
    }


    private void recur(int currentStep, HashMap<Integer, Integer> step) {

        if (currentStep < 0) return;

        step.merge(currentStep, 1, Integer::sum);
        recur(currentStep-1, step);
        recur(currentStep-2, step);



    }*/
}
