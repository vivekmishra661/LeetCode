package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class WordPattern_BestSolution {

    static void main() {
        WordPattern_BestSolution w = new WordPattern_BestSolution();
        w.wordPattern("abba", "dog cat cat dog");
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> m = new HashMap<>();
        HashSet<String> added = new HashSet<>();
        String[] s1 = s.trim().split("\\s+");
        if(s1.length!= pattern.length()){
            return false;
        }
        for(int i = 0; i<pattern.length(); i++){
            if(added.contains(s1[i]) && m.get(pattern.charAt(i)) == null){
                return false;
            }else if(m.get(pattern.charAt(i)) == null){
                m.put(pattern.charAt(i), s1[i]);
                added.add(s1[i]);
            }else if(!Objects.equals(m.get(pattern.charAt(i)), s1[i])){
                return false;
            }
        }
        return true;
    }
}
