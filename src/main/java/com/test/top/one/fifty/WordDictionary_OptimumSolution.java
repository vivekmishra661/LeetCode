package com.test.top.one.fifty;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WordDictionary_OptimumSolution {

    static void main() {
        WordDictionary_OptimumSolution wordDictionary = new WordDictionary_OptimumSolution();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("dad");
        wordDictionary.search("pad");
        wordDictionary.search("bad");
        wordDictionary.search(".ad");
        wordDictionary.search("b..");

    }

    class Trie {
        Character c;
        Map<Character, Trie> children;
        boolean isEnd;

        public Trie() {
            this.c = null;
            this.children = new HashMap<>();
        }

        public Trie(Character c) {
            this.c = c;
            this.children = new HashMap<>();
        }
    }

    Trie object;

    public WordDictionary_OptimumSolution() {
        object = new Trie();
    }

    public void addWord(String word) {
        char[] s = word.toCharArray();
        var currentRoot = this.object;
        var child = object.children;
        for (int i = 0; i < s.length; i++) {
            if (child.containsKey(s[i])) {
                if (i == s.length - 1) {
                    child.get(s[i]).isEnd = true;
                    break;
                }
                child = child.get(s[i]).children;
            } else {
                child.put(s[i], new Trie(s[i]));
                if (i == s.length - 1) {
                    child.get(s[i]).isEnd = true;
                    break;
                }
                child = child.get(s[i]).children;

            }
        }
    }

    public boolean search(String word){
        return search(word, this.object);
    }

    public boolean search(String word, Trie currentRoot) {
        char[] s = word.toCharArray();
        var child = currentRoot.children;
        for (int i = 0; i < s.length; i++) {
            if (child.isEmpty()) {
                return false;
            }
            if (s[i] == '.') {
                if (i == s.length - 1) {
                    return child.values().stream().anyMatch(e -> e.isEnd);
                } else {
                    Iterator<Trie> itr = child.values().iterator();
                    while (itr.hasNext()) {
                        if (search(word.substring(i+1, word.length()), itr.next())) {
                            return true;
                        }
                    }
                    return false;
                }

            }
            if (!child.containsKey(s[i])) {
                return false;

            } else {
                if (i == s.length - 1 && !child.get(s[i]).isEnd) {
                    return false;
                }
            }
            currentRoot = child.get(s[i]);
            child = currentRoot.children;

        }
        return true;
    }
}
