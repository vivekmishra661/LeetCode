package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis_OptimumSolution {


    static void main() {
        System.out.println(isValid("{[()(){[]}]}"));
    }

    private static boolean isValid(String s) {
        var t = s.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('}', '{');
            put(']', '[');
            put(')', '(');
        }};
        Stack<Character> ss = new Stack<>();
        List<Character> incoming = List.of('{', '[', '(');
        List<Character> outgoing = List.of('}', ']', ')');
        for (int i = 0; i < t.length; i++) {
            if (incoming.contains(t[i])) {
                ss.push(t[i]);
            } else if (outgoing.contains(t[i])) {
                if (!ss.empty() && ss.peek().equals(map.get(t[i]))) {
                    ss.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }

        }
        if(ss.empty())
        return true;
        return false;
    }
}
