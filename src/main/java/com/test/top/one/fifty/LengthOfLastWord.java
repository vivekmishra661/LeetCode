package com.test.top.one.fifty;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        String last = null;
        for(int i = 0;i<ss.length;i++){
            if(ss[i]!= " "){
                last = ss[i];
            }
        }
        return last.length();
    }
}
