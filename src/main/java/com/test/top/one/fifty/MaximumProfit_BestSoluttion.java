package com.test.top.one.fifty;

public class MaximumProfit_BestSoluttion {

    static void main() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        //[7,6,4,3,1]
    }

    public static int maxProfit(int[] prices) {
            int minimumValue = prices[0];
            int maxProfit = 0;

            for(int i =0 ;i<prices.length;i++){
                if(prices[i]< minimumValue){
                    minimumValue  = prices[i];
                }
                if(prices[i]> minimumValue && (prices[i]-minimumValue)>maxProfit){
                    maxProfit = prices[i]-minimumValue;
                }
            }
            return maxProfit;
    }

    public static int maxProfit2(int[] prices){
        int currentMinimum = prices[0];
        int maxProfit = 0;

        for(int i =0 ;i<prices.length;i++){
            if(prices[i]>currentMinimum){
                maxProfit = maxProfit + (prices[i] - currentMinimum);
                currentMinimum = prices[i];
            }else if(prices[i]<currentMinimum){
                currentMinimum = prices[i];
            }


        }
        return maxProfit;
    }
}
