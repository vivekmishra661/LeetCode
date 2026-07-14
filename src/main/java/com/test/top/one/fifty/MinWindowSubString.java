package com.test.top.one.fifty;

import java.util.*;

public class MinWindowSubString {

    public String minWindow(String s, String t) {
        Map<Character, List<Integer>> originalString = new HashMap<>();
        Map<Character, Integer> otherString = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int f = i;
            originalString.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(f);
                return v;
            });
        }
        for (int j = 0; j < t.length(); j++) {
            otherString.compute(s.charAt(j), (k, v) -> {
                if (v == null) {
                    v = 0;
                }
                v = v + 1;
                return v;
            });
        }
        if (otherString.keySet().stream().anyMatch(key ->
                originalString.get(key) == null || originalString.get(key).size()
                        < otherString.get(key)
        )) {
            return "";
        } else {
            int lowIndex = s.length();
            int highIndex = -1;
            Iterator<Character> iterator = otherString.keySet().iterator();
            while (iterator.hasNext()) {
                Character c = iterator.next();
                int minIndex = originalString.get(c).getFirst();
                int maxIndex = originalString.get(c).getLast();
                for(int i = 0;i< otherString.get(c); i++){


                }


            }

        }

        return "";


    }
}
