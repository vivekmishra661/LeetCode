package org.example;

import java.util.*;

public class LargestSubString {

    static void main() {
        System.out.println(LargestSubString.testOptimized("abcabcbb"));
    }

    static int test(String s){
        char[] ss = s.toCharArray();
        int ii = ss.length>0?1:0;
        for(int i=0;i<s.length();i++){
            int k= 0;
            Set<Character> t = new HashSet<>();
            for(int j =i; j<s.length();j++){
                if(t.contains(ss[j])) {
                    if(k>ii) ii=k;
                    break;
                }
                t.add(ss[j]);
                k++;
            }
            if(k>ii) ii=k;
        }
        return ii;
    }

    static int testOptimized(String s){
        char[] ss = s.toCharArray();
        int startIndex =0;
        int endIndex = 0;
        int[] previousBest  = {0,0};
        LinkedHashMap<Character, Integer> m = new LinkedHashMap<>();

        for(int i=0; i< ss.length; i++){
            if(!m.containsKey(ss[i])) {
                m.put(ss[i], i);
                endIndex=i;
            }else{
                var index  = m.get(ss[i]);
                if(previousBest[1]-previousBest[0] < endIndex-startIndex){
                    previousBest[0]= startIndex;
                    previousBest[1] = endIndex;
                }
                var it =m.entrySet().iterator();
                while(it.hasNext()){
                    var t = it.next();
                    if(t.getValue()<= index){
                        it.remove();
                    }

                }
                m.put(ss[i], i);
                startIndex = index+1;
                endIndex = i;

            }
        }
        if(ss.length ==0)return 0;
        if(previousBest[1]-previousBest[0] < endIndex-startIndex){
            return endIndex -startIndex +1;
        }else{
            return  previousBest[1]-previousBest[0]+1;
        }


    }
}
