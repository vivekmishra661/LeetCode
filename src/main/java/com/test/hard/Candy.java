package com.test.hard;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        for(int i = 0;i< ratings.length;i++){
            candy[i] = 1;
        }
        for(int i=1;i< ratings.length;i++){
            if(ratings[i-1]< ratings[i] && candy[i-1] >= candy[i]){
                candy[i] = candy[i-1]+1;
            }else if(ratings[i-1]>ratings[i] && candy[i]>=candy[i-1]){
                candy[i-1] = candy[i] +1;
            }
        }
        for(int i=ratings.length-1; i>0; i--){
            if(ratings[i-1]< ratings[i] && candy[i-1] >= candy[i]){
                candy[i] = candy[i-1]+1;
            }else if(ratings[i-1]>ratings[i] && candy[i]>=candy[i-1]){
                candy[i-1] = candy[i] +1;
            }
        }

        return Arrays.stream(candy).boxed().reduce((a,b)-> a+b).orElse(0);

    }
}
