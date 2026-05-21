package com.test.top.one.fifty;

public class Palindrome_OptimumSolution {

    public boolean isPalindrome(String s) {
        s= s.toLowerCase();
        StringBuilder ss1 = new StringBuilder();
        StringBuilder ss2 = new StringBuilder();
        for(int i= 0;i<s.length();i++){
            String p1 = String.valueOf(s.charAt(i));
            String p2 = String.valueOf(s.charAt(s.length()-1-i));
            if(p1.matches("[a-z0-9]")){
                ss1.append(p1);
            }
            if(p2.matches("[a-z0-9]")){
                ss2.append(p2);
            }
        }
        return ss1.toString().equals(ss2.toString());
    }
}
