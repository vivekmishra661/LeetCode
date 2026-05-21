package org.example;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Regex {

    static void main() {
        Regex t= new Regex();
        System.out.println(t.isMatch("aaa","aaaa"));
    }

    class CharType {
        String type;
        char s;

        public CharType(char s, String tpye) {
            this.s = s;
            this.type = tpye;
        }


    }

    public boolean isMatch(String s, String p) {
        char[] p1 = p.toCharArray();
        //identify * pair,
        char star = '*';
        char dot = '.';
        java.util.List<CharType> t = new ArrayList<>();

        for (int i = 0; i < p1.length ; i++) {
            if (i < p1.length - 1 && p1[i + 1] == star) {
                t.add(new CharType(p1[i], "star"));
                if(p1[i] == dot && (i+1) != (p1.length-1)) return false;
                i++;
            } else if (p1[i] == dot) {
                t.add(new CharType(p1[i], "dot"));

            } else {
                t.add(new CharType(p1[i], "char"));
            }
        }

        char[] s1 = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s1.length; i++) {
            if(j== t.size()) return  false;
            if (t.get(j).type.equals("dot")) {
                j++;
                continue;
            }
            if (t.get(j).type.equals("char")) {
                if (t.get(j).s != s1[i]) return false;
                j++;
            } else if (t.get(j).type.equals("star")) {
                char currentChar = t.get(j).s;
                int lloop = i;
                char firstCharInString = s1[i];
                j++;
                while (lloop < s1.length) {
                    if (currentChar != dot && currentChar != s1[lloop]) {
                        i = lloop -1;
                        break;
                    }
                    i = lloop ;
                    lloop++;
                }
            }
        }
        if(j< t.size()) return false;

        return true;

    }
}
