package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion_BestSolution {

    static void main() {
        System.out.println(ZigZagConversion_BestSolution.test("A",1));
    }

    public static String test(String s1, int rows){
        //row 1  and last has same skips as number of rows;
        // row 2 to last -1 depends to height

        char[] sArray = s1.toCharArray();
        StringBuilder s  = new StringBuilder();
        if(rows==1) return s1;
        for(int i  = 0; i< rows; i++){
            if(i ==0  ){                              //0 + 2+ 1 = 3
                for(int j = 0; j < sArray.length; j= j + 2*(rows-1)){
                    s.append(sArray[j]);
                }
            }

            //PAHNAPLSIIGYIR
            //PAHNAPLSIIGYIR
            //PINALSIGYAHRPI
            //PINALSIGYAHRPI
            if(i>0 && i< rows-1){
                int j = i;
                int originalJ = i;
                boolean ceiling = true;
                while(j<sArray.length){
                    s.append(sArray[j]);
                    if(ceiling){
                        j = j+  2*(rows -  (originalJ+1));
                        ceiling = !ceiling;
                    }else{
                        j = j+ 2*originalJ;
                        ceiling = !ceiling;
                    }
                }
            }
           if(i== rows-1){
               for(int j = rows-1; j < sArray.length; j = j + 2*(rows-1)){
                   s.append(sArray[j]);
               }
           }

        }
        return s.toString();

    }


    public void test1(String s1, int rows){
        List<List<Character>> m = new ArrayList<>();
        char[] s1Array = s1.toCharArray();
        int currentIndex = 0;
        int currentRowCount = 0;
        for(int i = 0; i< s1Array.length ; i++){
            ArrayList<Character> k = null;
            if(i<rows){
                k = new ArrayList<>();
                m.add(k);
            }








        }

    }
}
