package com.test.top.one.fifty;

import java.util.HashSet;

public class HappyNumber_OptimumSolution {

    static void main() {
        HappyNumber_OptimumSolution h = new HappyNumber_OptimumSolution();
        h.isHappy(2);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true){
            char[] pow=  String.valueOf(n).toCharArray();
            int sum =0;
            for(int i =0; i<pow.length;i++){
                sum += Math.powExact(Integer.valueOf(String.valueOf(pow[i])),2);
            }
            if(sum ==1){
                return true;
            }
            if(set.contains(sum)){
                return false;
            }else{
                set.add(sum);
                n = sum;
            }


        }

    }
}
