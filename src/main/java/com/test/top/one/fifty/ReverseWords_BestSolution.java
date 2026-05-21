package com.test.top.one.fifty;

import java.util.Objects;

public class ReverseWords_BestSolution {

    static void main() {
        ReverseWords_BestSolution r = new ReverseWords_BestSolution();
        r.reverseWords(" the sky  is  blue  ");
    }

    public String reverseWords(String s) {
        s=  s.trim();
        String[] ss = s.split("\\s+");
        StringBuilder sp = new StringBuilder();
        for(int i = ss.length-1; i>=0;i--){
            if(i<ss.length-1 ){
                sp.append(" ");
            }
            if(!Objects.equals(ss[i], " ")){
                sp.append(ss[i]);
            }
        }
        return sp.toString();

    }
}
