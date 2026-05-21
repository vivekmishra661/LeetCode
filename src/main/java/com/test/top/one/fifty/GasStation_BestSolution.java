package com.test.top.one.fifty;

public class GasStation_BestSolution {

    static void main() {
        GasStation_BestSolution gasStation = new GasStation_BestSolution();
        var t = gasStation.canCompleteCircuit(new int[]{3,1,1}, new int[]{1,2,2});
        System.out.println(t);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        //first greedy
        int gasAll = 0;
        int costAll = 0;
        for (int i = 0; i < gas.length; i++) {
            gasAll += gas[i];
            costAll += cost[i];
        }
        if (gasAll < costAll) {
            return -1;
        }
        int currentGas = 0;
        int count = 0;
        int currentIndex = 0;
        int startIndex = currentIndex;

        while (count < gas.length) {
            if (currentIndex == gas.length) {
                currentIndex = 0;
            }
            currentGas = (gas[currentIndex] - cost[currentIndex]) + currentGas;
            if (currentGas < 0) {
                count = 0;
                currentGas = 0;
                startIndex = currentIndex+1;
                currentIndex++;
                continue;

            }
            currentIndex++;
            count++;
        }
        if (currentIndex == gas.length) {
            currentIndex = 0;
        }
        if ( startIndex == currentIndex) {
            return startIndex;
        }


        return -1;
    }


}
