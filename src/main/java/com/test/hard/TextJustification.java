package com.test.hard;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class TextJustification {

    static void main() {
        TextJustification textJustification = new TextJustification();
       // var t = textJustification.fullJustify(new String[]{"ask","not","what","your","country","can","do","for",
         //       "you","ask","what","you","can","do","for","your","country"}, 16);
        var t = textJustification.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16);
        for (int i = 0; i < t.size(); i++) {
            System.out.println("|" + t.get(i) + "|");
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int currentLength = 0;
        List<List<String>> array = new ArrayList<>();
        Map<Integer, Integer> rowWordLength = new HashMap<>();
        array.add(new ArrayList<>());
        int currentRIndex = 0;
        for (int i = 0; i < words.length; i++) {
            var currentRow = array.getLast();
            var currentWord = words[i];
            currentRow.add(currentWord);
            currentLength += currentWord.length();
            rowWordLength.put(currentRIndex, currentLength);
            if (currentLength + currentRow.size() - 1 > maxWidth) {
                String removed = currentRow.removeLast();
                rowWordLength.put(currentRIndex, currentLength - removed.length());
                i--;
                array.add(new ArrayList<>());
                currentRIndex++;
                currentLength = 0;
            }
        }
        List<String> finalString = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            boolean isLastRow = i == array.size() - 1;
            var numberOfWords = array.get(i).size();
            var wordsLength = rowWordLength.get(i);
            int blanksToFill = maxWidth - wordsLength;
            int extraBlanks = 0;
            int avgBlanks =0;
            if (numberOfWords > 1) {
                avgBlanks = blanksToFill / (numberOfWords - 1);
                extraBlanks = blanksToFill % (numberOfWords - 1);
                if(isLastRow){
                    avgBlanks = 1;
                    extraBlanks = blanksToFill - (avgBlanks*(numberOfWords-1));

                }
            } else {
                extraBlanks = blanksToFill;
            }
            StringBuilder s = new StringBuilder();
            AtomicInteger x = new AtomicInteger(extraBlanks);
            for (int j = 0; j < array.get(i).size(); j++) {
                var currentRow = array.get(i);
                s.append(currentRow.get(j));
                if (numberOfWords > 1 && j < currentRow.size()-1) {
                    IntStream.range(0, avgBlanks).forEach(e -> {
                        s.append(" ");
                        if (x.get() > 0 && !isLastRow) {
                            s.append(" ");
                            x.decrementAndGet();
                        }
                    });
                }
            }
            if (isLastRow || numberOfWords ==1) {
                IntStream.range(0, extraBlanks).forEach(e -> s.append(" "));
            }

            finalString.add(s.toString());

        }

        return finalString;
    }
}
