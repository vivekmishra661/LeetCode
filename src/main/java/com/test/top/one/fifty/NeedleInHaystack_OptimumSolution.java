package com.test.top.one.fifty;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NeedleInHaystack_OptimumSolution {

    public int strStr(String haystack, String needle) {
        Pattern p = Pattern.compile(needle);
        Matcher matcher = p.matcher(haystack);

        if (matcher.find()) {
           return matcher.start();
        }
        return -1;
    }
}
