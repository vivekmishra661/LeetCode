package com.test.top.one.fifty;

import java.util.Map;
import java.util.TreeMap;

public class RomanToInteger_OptimumSolution {

    static void main() {
        RomanToInteger_OptimumSolution r = new RomanToInteger_OptimumSolution();
       // r.romanToInt("MCMXCIV");
        r.intToRoman_FixMe(3749);
    }

    public int romanToInt(String s) {
        Map<String, Integer> st=  new TreeMap<>();
        st.put("M", 1000);
        st.put("CM", 900);
        st.put("D",500);
        st.put("CD", 400);
        st.put("C",100);
        st.put("XC", 90);
        st.put("L",50);
        st.put("XL", 40);
        st.put("X",10);
        st.put("IX",9);
        st.put("V",5);
        st.put("IV",4);
        st.put("I",1);
        var  p = s.toCharArray();
        int previousElement = 0;
        int totalElement  = 0;
        for(int i=0;i<p.length;i++){
            var currentElement = st.get(String.valueOf(p[i]));
            if(i>0 && st.get(p[i - 1] +"" + p[i])!= null){
                var  t = st.get(p[i - 1] +"" + p[i]);
                totalElement = totalElement - previousElement;
                totalElement += t;
                previousElement = 0;
            }else{
                totalElement += currentElement;
                previousElement= currentElement;
            }


        }

        return totalElement;

    }

    public String intToRoman_FixMe(int s) {
        Map<Integer, String> st=  new TreeMap<>();
        int power  = String.valueOf(s).length()-1;
        st.put( 1000,"M");
        st.put( 900,"CM");
        st.put(500,"D");
        st.put( 400,"CD");
        st.put(100,"C");
        st.put( 90,"XC");
        st.put(50,"L");
        st.put( 40,"XL");
        st.put(10,"X");
        st.put(9,"IX");
        st.put(5,"V");
        st.put(4,"IV");
        st.put(1,"I");
        StringBuilder ss = new StringBuilder();
        for(int i = power; i>=0;i--){
            int currentPw = Math.powExact(10,i);
            int remainders = s%currentPw;
            var value = s-remainders;
            if(st.get(value)!= null){
                ss.append(st.get(value));
            }else{
                int k = value/currentPw;
                if(k>5){
                    var t = 5*currentPw;
                    var t1  = st.get(t);
                    ss.append(t1);
                    for(int x = 0 ; x<(k-5);x++){
                        var t2  = st.get(currentPw);
                        ss.append(t2);
                    }
                }else{
                    var t1  = st.get(currentPw);
                    for(int x = 0 ; x<k;x++){
                        var t2  = st.get(currentPw);
                        ss.append(t2);
                    }
                }
            }
            s = s%currentPw;
        }
        System.out.println(ss.toString());
        return ss.toString();
        //MMMDCCXLIX
        //MMMDXXXLIX
    }
}
