package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MinPathTriangle {

    static void main() {
        MinPathTriangle minPathTriangle = new MinPathTriangle();
        //[[2],[3,4],[6,5,7],[4,1,8,3]]
        List<Integer> t = new ArrayList<>();
        t.add(2);
        List<Integer> t2 =  new ArrayList<>();
        t2.add(3);
        t2.add(4);
        List<Integer> t3 = new ArrayList<>();
        t3.add(6);
        t3.add(5);
        t3.add(7);
        List<Integer> t4 = new ArrayList<>();
        t4.add(4);
        t4.add(1);
        t4.add(8);
        t4.add(3);
        minPathTriangle.minimumTotal(List.of(t,t2,t3,t4));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
       for(int i = triangle.size()-2; i>= 0 ; i--){
           for(int j =0;j<=triangle.get(i).size()-1; j++){
               int min = Math.min(triangle.get(i+1).get(j) , triangle.get(i+1).get(j+1));
               int current  = triangle.get(i).get(j);
               System.out.println("setting value"+ i + " "+ j + " " + min + " " + current );
               triangle.get(i).set(j, min + current);
           }
       }
       return triangle.get(0).get(0);
    }

}
