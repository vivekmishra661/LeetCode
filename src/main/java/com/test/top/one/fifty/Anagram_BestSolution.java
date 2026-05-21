package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Map;

public class Anagram_BestSolution {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m = new HashMap<>();
        if(s.length()!= t.length())return false;
        for(int i=0;i<s.length();i++){
            m.compute(s.charAt(i), (k,v)-> v==null? 1: v+1);
            m.compute(t.charAt(i), (k,v)-> v==null? -1: v-1);
        }

        return m.values().stream().noneMatch(k-> k!=0);
    }
}
