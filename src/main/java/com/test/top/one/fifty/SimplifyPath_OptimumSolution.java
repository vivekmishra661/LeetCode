package com.test.top.one.fifty;

import java.util.Stack;

public class SimplifyPath_OptimumSolution {

    static void main() {
        SimplifyPath_OptimumSolution s = new SimplifyPath_OptimumSolution();
        System.out.println(s.simplifyPath("/.../a/../b/c/../d/./"));
    }

    public String simplifyPath(String path) {
        String back = "..";
        String current = ".";
        String[] m = path.split("/+");
        Stack<String> stringStack = new Stack<>();

        for(int i = 0; i<m.length;i++){
            if(m[i].isEmpty()){
                continue;
            }
            if(current.equals(m[i])){
                continue;
            }else if(back.equals(m[i])){
                if(!stringStack.isEmpty())
                stringStack.pop();
            }else{
                stringStack.push(m[i]);
            }
        }
        if(stringStack.isEmpty()){
            return "/";
        }
        return "/"+  String.join("/", stringStack);

    }
}
