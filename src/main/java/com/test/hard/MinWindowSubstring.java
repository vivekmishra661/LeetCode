package com.test.hard;

import java.util.*;

public class MinWindowSubstring {

    static void main() {
        MinWindowSubstring minWindowSubstring = new MinWindowSubstring();
        minWindowSubstring.minWindow("ab", "a");
    }

    public String minWindow(String s, String t) {
        int windowSize = t.length();
        Map<Character, Integer> characterInSearchString = new HashMap<>();
        Map<Character, List<Integer>> characterInString = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            characterInSearchString.compute(t.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            int f = i;
            if (characterInSearchString.containsKey(s.charAt(i))) {
                characterInString.compute(s.charAt(i), (k, v) -> {
                    if (v == null) {
                        v = new ArrayList<Integer>();
                    }
                    v.add(f);
                    return v;
                });
            }
        }
        characterInString.values().stream().forEach(e -> e.sort(Comparator.naturalOrder()));
        int firstPointer = 0;
        int lastPointer = firstPointer+windowSize-1;
        int[] pointers = new int[]{-1, -1};
        int firstLastCharacter = 0;
        if(s.equals(t)){
            return s;
        }
        while (lastPointer < s.length() && (lastPointer - firstPointer) >= windowSize) {
            var fN = firstPointer;
            var lN = lastPointer;

            boolean isPresent = true;
            for (Character c : characterInSearchString.keySet()) {
                long totalPresent = characterInString.get(c).stream().filter(e -> e >= fN && e <= lN).count();
                if (totalPresent > 0) {
                    var neChar = characterInString.get(c).stream().filter(e -> e >= fN && e <= lN).findFirst().get();
                    if (firstLastCharacter > firstPointer && neChar > firstPointer) {
                        firstLastCharacter = Math.min(neChar, firstLastCharacter);
                    } else {
                        firstLastCharacter = neChar;
                    }
                }
                if (totalPresent < characterInSearchString.get(c)) {
                    if (lastPointer - firstPointer > windowSize && lastPointer == s.length() - 1) {
                        firstPointer++;
                    } else {
                        lastPointer++;
                    }

                    isPresent = false;
                    break;
                }
            }
            if (isPresent) {

                if (pointers[0] > -1 && pointers[1] > -1) {
                    var delta = lastPointer - firstPointer;
                    if (delta < pointers[1] - pointers[0]) {
                        pointers[0] = firstPointer;
                        pointers[1] = lastPointer;
                    }
                } else {
                    pointers[0] = firstPointer;
                    pointers[1] = lastPointer;
                }

                if (lastPointer - firstPointer > windowSize && lastPointer == s.length() - 1) {
                    firstPointer++;
                } else {
                    lastPointer++;
                    firstPointer = firstLastCharacter;
                }
            }


        }
        if (pointers[0] > -1 && pointers[1] > -1)
            return s.substring(pointers[0], pointers[1]+1);
        else return "";
    }
}
