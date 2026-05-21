package com.test.top.one.fifty;

public class LsSubsequence_BestSolution {

    static void main() {
        LsSubsequence_BestSolution lsSubsequence = new LsSubsequence_BestSolution();
        lsSubsequence.isSubsequence("abc","ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {

        int subSeqCount = 0;
        if(!s.isEmpty()) {
            for (int i = 0; i < t.length(); i++) {
                if(subSeqCount == s.length()){
                    break;
                }
                if (s.charAt(subSeqCount) == t.charAt(i)) {
                    subSeqCount++;
                }
            }
        }
        return subSeqCount == s.length();
    }


}
