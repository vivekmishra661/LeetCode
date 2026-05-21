package org.example;

public class ReverseInteger {

    static void main() {
        ReverseInteger.test(-2147483648);
    }

    public static int test(int x){

        Long maxInt = Long.parseLong(String.valueOf(Integer.MAX_VALUE));
        Long minInt  = Long.parseLong(String.valueOf(Integer.MIN_VALUE));

        boolean isNegative  = x<0;

        char[] ss = isNegative ? String.valueOf(x).substring(1).toCharArray() : String.valueOf(x).toCharArray();

        StringBuilder sss = new StringBuilder();

        for(int i=ss.length-1; i>=0;i--){
            sss.append(ss[i]);
        }

        String revString = sss.toString();
        Long revLong = null;
        if(isNegative){
            revLong =  Long.parseLong("-"+revString);
        }else
         revLong = Long.parseLong(revString);
        if(revLong> maxInt || revLong< minInt)
            return 0;

        return isNegative? ((Integer.parseInt("-"+revString))): Integer.parseInt(revString);
    }
}
