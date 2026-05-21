package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Map;

public class Trie_OptimumSolution {

    static void main() {
        Trie_OptimumSolution t = new Trie_OptimumSolution();
        t.insert("apple");
        t.search("apple");
        t.search("app");
        t.startsWith("app");
        t.insert("app");
    }

    Map<Character, Trie_OptimumSolution> children;
    boolean isEnd = false;
    Character c = null;

    public Trie_OptimumSolution(Character c) {
        children = new HashMap<>();
        this.c = c;
    }

    public Trie_OptimumSolution(){
        children = new HashMap<>();
        this.c = null;
    }

    public void insert(String word) {
        char[] c = word.toCharArray();
        var child = this.children;
        for(int i = 0; i< c.length;i++){
            if(child.get(c[i])== null){
                child.put(c[i], new Trie_OptimumSolution(c[i]));
                if(i == c.length-1){
                    child.get(c[i]).isEnd =true;
                }
                child  = child.get(c[i]).children;
            }else{
                if(i == c.length-1){
                    child.get(c[i]).isEnd =true;
                }
                child  = child.get(c[i]).children;
            }
        }
    }

    public boolean search(String word) {
        char[] c = word.toCharArray();
        boolean isPresent  = true;
        var child = this.children;
        for(int i = 0; i< c.length;i++){
            if(child.get(c[i])==null){
                isPresent =false;
                break;
            }else{
                if(i == c.length-1 && !child.get(c[i]).isEnd ){
                    isPresent =false;
                    break;
                }
                child  = child.get(c[i]).children;

            }
        }
        return isPresent;
    }

    public boolean startsWith(String prefix) {
        char[] c = prefix.toCharArray();
        boolean isPresent  = true;
        var child = this.children;
        for(int i = 0; i< c.length;i++){
            if(child.get(c[i])==null){
                isPresent =false;
                break;
            }else{
                child  = child.get(c[i]).children;
            }
        }
        return isPresent;
    }
}
