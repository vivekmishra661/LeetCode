package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphic {

    static void main() {
        IsoMorphic s = new IsoMorphic();
        System.out.println(s.isIsomorphic("foo", "bar"));
    }

    public boolean isIsomorphic(String s, String t) {

        if(s.length()!= t.length())return false;
        Map<Character, Character>  oneToTwoMap = new HashMap<>();
        Map<Character, Character>  twoToOneMap = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            if(oneToTwoMap.get(s.charAt(i)) == null ){
                oneToTwoMap.put(s.charAt(i), t.charAt(i));
            }else if( oneToTwoMap.get(s.charAt(i)) != t.charAt(i)){
                return false;
            }
            if(twoToOneMap.get(t.charAt(i)) == null){
                twoToOneMap.put(t.charAt(i), s.charAt(i));
            }else if(twoToOneMap.get(t.charAt(i)) != s.charAt(i)){
                return false;
            }

        }
        return true;

    }
}
