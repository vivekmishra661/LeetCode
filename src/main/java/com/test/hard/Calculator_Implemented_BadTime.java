package com.test.hard;

import java.util.*;

public class Calculator_Implemented_BadTime {

    // o(n^2) bad implementation


    static void main() {
        Calculator_Implemented_BadTime calculator = new Calculator_Implemented_BadTime();
        int val = calculator.calculate("");
        System.out.println(val);
    }


    public int calculate(String s) {
        List<List<String>> wordStack = new ArrayList<>();
        List<String> numbers = List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");
        List<String> currentStack = new ArrayList<>();
        wordStack.add(currentStack);
        int currentStackIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '+', '-', '*', '/':
                    currentStack.add(String.valueOf(ch));
                    break;
                case ' ':
                    break;
                case '(':
                    var stackIndex = currentStackIndex + "X" + i;
                    currentStack.add(stackIndex);
                    currentStackIndex++;
                    currentStack = new ArrayList<>();
                    wordStack.add(currentStack);
                    break;
                case ')':
                    int value = calculateExpression(currentStack);
                    wordStack.removeLast();
                    currentStack = wordStack.getLast();
                    currentStack.removeLast();
                    currentStack.add(String.valueOf(value));
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    if (!currentStack.isEmpty() && currentStack.getLast() != null && numbers.contains(currentStack.getLast().substring(currentStack.getLast().length() - 1))) {
                        String newLast = currentStack.getLast() + String.valueOf(ch);
                        currentStack.removeLast();
                        currentStack.add(newLast);
                    } else {
                        currentStack.add(String.valueOf(ch));
                    }
                    break;
            }
        }

        return calculateExpression(wordStack.getFirst());


    }

    private Integer calculateExpression(List<String> string) {
        if(string.getFirst().equals("-")) {
            string.removeFirst();
            var val = -Long.parseLong(string.removeFirst());
            string.addFirst(String.valueOf( val));
        }
        while (true) {
            if (string.contains("/")) {
                var index = string.indexOf("/");
                var fP = Long.valueOf(string.get(index - 1));
                var lP = Long.valueOf(string.get(index + 1));
                long calculation = fP/ lP;
                string.remove(index - 1);
                string.remove(index - 1);
                string.remove(index - 1);
                string.add(index - 1, String.valueOf(calculation));
                continue;
            } else if (string.contains("*")) {
                var index = string.indexOf("*");
                var fP =Long.valueOf( string.get(index - 1));
                var lP = Long.valueOf(string.get(index + 1));
                long calculation = fP*lP;
                string.remove(index - 1);
                string.remove(index - 1);
                string.remove(index - 1);
                string.add(index - 1, String.valueOf(calculation));
                continue;
            } else if (string.contains("+") || string.contains("-")) {
                var pindex = string.indexOf("+");
                var nindex = string.indexOf("-");
                boolean isAddition = true;
                int index = -1;
                long calculation = 0;
                if (nindex > 0 && pindex > 0) {
                    index = Math.min(pindex, nindex);
                    isAddition = pindex < nindex;
                } else {
                    index = pindex < 0 ? nindex : pindex;
                    if (pindex < 0) {
                        isAddition = false;
                    }
                }
                var fP = Long.valueOf(string.get(index - 1));
                var lP = Long.valueOf(string.get(index + 1));
                if (isAddition)
                    calculation = fP + lP;
                else
                    calculation = fP - lP;
                string.remove(index - 1);
                string.remove(index - 1);
                string.remove(index - 1);
                string.add(index - 1, String.valueOf(calculation));
                continue;
            }
            break;

        }
            return Long.valueOf(string.getFirst()).intValue();
    }
}