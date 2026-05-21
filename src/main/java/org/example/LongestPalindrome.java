package org.example;

public class LongestPalindrome {

    static void main() {
        System.out.println(LongestPalindrome.longestPalindrome("bacabxygyz"));
    }

    public static String longestPalindrome(String s) {
        //int startSize = 2;
        int len = s.length();
        boolean[][] dpArray = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dpArray[i][i] = true;
        }
        int[] max = new int[2];
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dpArray[i][i + 1] = true;
                max[0] = i;
                max[1] = i + 1;
            }
        }

        for (int k = 2; k < len; k++) {  //going by increasing window size from 2 to max length
            for (int i = 0; i < len - k; i++) {// going till len-k as window endindex will slide till endindex using j
                int j = i + k; //end index of sliding window
                if (s.charAt(i) == s.charAt(j) && dpArray[i + 1][j - 1]) {
                    dpArray[i][j] = true;
                    max[0] = i;
                    max[1] = j;
                }
            }
        }
        return s.substring(max[0], max[1] + 1);
    }
}
