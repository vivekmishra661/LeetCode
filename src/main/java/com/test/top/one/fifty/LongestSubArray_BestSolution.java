package com.test.top.one.fifty;

import java.util.LinkedHashMap;

public class LongestSubArray_BestSolution {

    static void main() {
        LongestSubArray_BestSolution s = new LongestSubArray_BestSolution();
        System.out.println(s.lengthOfLongestSubstring("wobgrovw"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();
        int startIndex =0;
        int endIndex = 0;
        int prevStart = 0;
        int prevEnd = 0;
        LinkedHashMap<Character, Integer> m = new LinkedHashMap<>();

        for(int i=0; i< ss.length; i++){
            if(!m.containsKey(ss[i]) || m.get(ss[i])<startIndex) {
                m.put(ss[i], i);
                endIndex=i;
            }else{
                if((prevEnd-prevStart) < (endIndex-startIndex)){
                    prevStart = startIndex;
                    prevEnd = endIndex;
                }
                startIndex = m.get(ss[i])+1;
                endIndex = i;
                m.put(ss[i], i);
            }
        }
        if(ss.length ==0)return 0;
        if((prevEnd-prevStart) < (endIndex-startIndex)){
            return endIndex -startIndex +1;
        }else{
            return  prevEnd-prevStart+1;
        }


    }
}
