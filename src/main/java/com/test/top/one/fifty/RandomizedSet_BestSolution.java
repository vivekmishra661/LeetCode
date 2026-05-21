package com.test.top.one.fifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet_BestSolution {


    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> list  = new ArrayList<>();

    static void main() {
        RandomizedSet_BestSolution randomizedSet = new RandomizedSet_BestSolution();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.getRandom();
    }


    public RandomizedSet_BestSolution() {

    }

    public boolean insert(int val) {
        if(map.get(val) == null){
            var index  = list.size();
            list.add(val);
            map.put(val, index);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(map.get(val) != null){
            var index  = map.get(val);
            var finalElement  = list.getLast();
            list.set(index, finalElement);
            list.set(list.size()-1, val);
            list.removeLast();
            map.put(finalElement, index);
            map.remove(val);
            return true;
        }

        return false;

    }

    public int getRandom() {
        int randomNum = (int)(Math.random() * (list.size()-1 - 0 + 1)) + 0;
        return list.get(randomNum);
    }
}
