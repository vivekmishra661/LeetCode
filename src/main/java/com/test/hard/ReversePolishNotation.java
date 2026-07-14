package com.test.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        List<String> annotation = new ArrayList<>(List.of(new String[]{"+", "-", "*", "/"}));
        Stack<Integer>  tok = new Stack<>();
        for(int i =0; i<tokens.length;i++){
            var current = tokens[i];
            if(!annotation.contains(current)){
                tok.add(Integer.valueOf(current));
            }else{
                var l = tok.pop();
                var f = tok.pop();
                switch (current){
                    case "+":
                        int fN = f+l;
                        tok.add(fN);
                        break;
                    case "-":
                        int fn1 = f-l;
                        tok.add(fn1);
                        break;
                    case "*":
                        int fn2 = f*l;
                        tok.add(fn2);
                        break;
                    case "/":
                        int fn3 = f/l;
                        tok.add(fn3);
                        break;
                }
            }
        }

        return tok.pop();
    }
}
