package com.test.top.one.fifty;

public class LongestPalidrome_BestSolution {

    static void main() {
        LongestPalidrome_BestSolution longestPalidrome = new LongestPalidrome_BestSolution();
        longestPalidrome.longestPalindrome("cbbd");
    }

    public String longestPalindrome(String s) {
       int leftIndex = 0;
       int rightIndex = 0;
       int maxLength = 0;
       for(int i =0; i<s.length();i++){
           int  oneCharPalindrome = expand(i, i , s);
           int twoCharPalindrowe = expand(i, i+1,s);
           int len = Math.max(oneCharPalindrome, twoCharPalindrowe);
           if(len> maxLength){
               maxLength = len;
               leftIndex = i- (len-1)/2;
               rightIndex = i + (len)/2;
           }
       }
       return s.substring(leftIndex,rightIndex+1);
    }

    private int expand(int left, int right, String s){
        while(left>=0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            if(left==0 || right == s.length()-1) break;
            left--;
            right++;
        }
        return right-left-1;
    }
}
