package com.test.top.one.fifty;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram_BestSolution {

    static void main() {
        GroupAnagram_BestSolution g = new GroupAnagram_BestSolution();
        g.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> m = new HashMap<>();
        for(int i =0; i<strs.length;i++){
            char[] t = strs[i].toCharArray();
            Arrays.sort(t);
            String kk = new String(t);
            m.compute(kk, (k,v)-> v==null? new ArrayList<>(): v);
            m.get(kk).add(i);
        }

        List<List<String>>  p = m.values().stream().map(k ->{
            var t= new ArrayList<String>();
            k.stream().forEach(pp-> t.add(strs[pp]));
            return t;
        }).collect(Collectors.toList());

        return p;


    }
}
