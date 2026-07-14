package com.test.top.one.fifty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HIndex {

    static void main() {
        HIndex hIndex = new HIndex();
        hIndex.hIndex(new int[]{100});
    }

    public int hIndex(int[] citations) {

        List<Integer> h = Arrays.stream(citations).boxed().toList().stream().sorted().toList();
        int hIndex = 0;

        for(int i = 0; i< h.size();i++){
            int sizeLeft = h.size()-i;
            int value = h.get(i);
            if(sizeLeft>hIndex && value> hIndex){
                if(sizeLeft<value){
                    hIndex = sizeLeft;
                }else{
                    hIndex = value;
                }
            }
        }

        return hIndex;

    }


}
