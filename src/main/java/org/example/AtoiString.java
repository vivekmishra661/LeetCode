package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class AtoiString {

    static void main() {
        System.out.println(AtoiString.test("  0000000000012345678"));
    }

    public static int test(String s){


        var maxIntStr = String.valueOf(Integer.MAX_VALUE).length();
        var minIntStr = String.valueOf(Integer.MIN_VALUE).length();
        Long maxInt = Long.parseLong(String.valueOf(Integer.MAX_VALUE));
        Long minInt  = Long.parseLong(String.valueOf(Integer.MIN_VALUE));
        char[] ss = s.toCharArray();
        boolean isNegative = false;
        StringBuilder finalS = new StringBuilder();
        boolean isInitial = true;
        char plus = '+';
        char minus = '-';
        char zero = '0';
        boolean isNumbered= false;
        for(int i = 0; i< ss.length;i++ ){
            if(Pattern.matches("\\d",String.valueOf(ss[i]))){
                if(i>0){
                    char t = '-';
                    if(t == ss[i-1]){
                        isNegative =true;
                    }
                }
                if(!isNumbered && ss[i]==zero){
                    isInitial =false;
                    continue;
                }
                isNumbered =true;
                finalS.append(ss[i]);
                isInitial= false;
            }else if(isInitial && (plus == ss[i] || minus == ss[i]
                    || Pattern.matches("\\s", String.valueOf(ss[i])))){
                if(plus == ss[i] || minus == ss[i]){
                    isInitial= false;
                }
            }
            else if(!Pattern.matches("\\d", String.valueOf(ss[i]))){
                break;
            }
        }

        if("".equals(finalS.toString())){
            return 0;
        }
        Long value  = null;
        if(isNegative){
            // ;
            if(finalS.toString().length()> minIntStr || Long.valueOf("-" + finalS.toString()) < minInt) {
                return Integer.MIN_VALUE;
            } else{
                return Long.valueOf("-" + finalS.toString()).intValue();
            }
        }else {
            if(finalS.toString().length()> maxIntStr || Long.valueOf( finalS.toString()) > maxInt) {
                return Integer.MAX_VALUE;
            } else{
                return Long.valueOf( finalS.toString()).intValue();
            }

        }

    }
}
