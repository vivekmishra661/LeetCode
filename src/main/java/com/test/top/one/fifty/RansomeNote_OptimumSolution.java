package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote_OptimumSolution {

    static void main() {

        RansomeNote_OptimumSolution r = new RansomeNote_OptimumSolution();
        r.canConstruct("aa","aab");

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> m1= new HashMap<>();
        for(int i = 0; i< Math.max(ransomNote.length(), magazine.length());i++){
                if(i< ransomNote.length()){
                    m1.compute(ransomNote.charAt(i), (k,v)-> v==null? -1 :v-1);
                }
                if(i<magazine.length()){
                    m1.compute(magazine.charAt(i), (k,v)-> v==null? 1 :v+1);
                }
        }

        return m1.values().stream().noneMatch(e-> e<0);


    }
}
