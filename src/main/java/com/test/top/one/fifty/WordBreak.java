package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak {

    static void main() {
        WordBreak wordBreak = new WordBreak();
        wordBreak.wordBreak("aaaaaaa", List.of("aaa", "aaaa"));
       // wordBreak.wordBreak("leetcode", List.of("leet", "code"));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie t = new Trie();
        for (String s1 : wordDict) {
            t.insert(s1);
        }
        return t.search(s);
    }


    class Trie {
        Map<Character, Trie> children;
        boolean isEnd;
        Character currentCharacter;

        public Trie() {
            this.currentCharacter = null;
            this.children = new HashMap<>();
        }

        public Trie(Character c) {
            this.currentCharacter = c;
            this.children = new HashMap<>();
        }

        public void insert(String s) {
            char[] p = s.toCharArray();
            var current = this;
            for (int i = 0; i < p.length; i++) {
                if (current.children.get(p[i]) == null) {
                    var t = new Trie(p[i]);
                    current.children.put(p[i], t);
                    current = t;
                } else {
                    current = current.children.get(p[i]);
                }
                if (i == p.length - 1) {
                    current.isEnd = true;
                }

            }
        }

        public boolean search(String v) {
            char[] p = v.toCharArray();
            var current = this;
            for (int i = 0; i < p.length; i++) {
                if (current.children.get(p[i]) == null) {
                    return false;
                } else {
                    current = current.children.get(p[i]);
                    if (current.isEnd && i < p.length-1) {
                        current = this;

                    }
                }
            }
            if(current.isEnd) return true;
            return false;
        }
    }

}
