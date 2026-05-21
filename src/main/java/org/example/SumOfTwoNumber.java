package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SumOfTwoNumber {



        public int[] twoSum(int[] nums, int target) {
            TreeMap<Integer, List<Integer>> kOdd = new TreeMap<>();
            TreeMap<Integer, List<Integer>> kEven = new TreeMap<>();
            for(int i=0;i<nums.length;i++){
                if(nums[i]%2==0){
                    if(kEven.get(nums[i])==null)
                        kEven.put(nums[i],new ArrayList<>());
                    kEven.get(nums[i]).add(i);
                }else{
                    if(kOdd.get(nums[i])==null)
                        kOdd.put(nums[i],new ArrayList<>());
                    kOdd.get(nums[i]).add(i);
                }

            }
            if(target%2 != 0){
                var kEvenKeySet = kEven.keySet().stream().collect(Collectors.toList());
                var kOddKeySet= kOdd.keySet().stream().collect(Collectors.toList());
                for(int i=0; i<kOddKeySet.size();i++){
                    for(int j =0; j<kEvenKeySet.size();j++){
                        //  if(j==i ) continue;
                        if(kOddKeySet.get(i) + kEvenKeySet.get(j) == target){
                            return new int[] {kOdd.get(kOddKeySet.get(i)).get(0),
                                    kEven.get(kEvenKeySet.get(j)).get(0)};
                        }
                    }
                }
            }else{
                var kEvenKeySet = kEven.keySet().stream().collect(Collectors.toList());
                var kOddKeySet= kOdd.keySet().stream().collect(Collectors.toList());
                for(int i=0; i<kOddKeySet.size();i++){
                    for(int j =0; j<kOddKeySet.size();j++){
                        if(j==i && kOdd.get(kOddKeySet.get(i)).size()==2 &&
                                kOddKeySet.get(i) + kOddKeySet.get(j) == target
                        ){
                            return new int[] {kOdd.get(kOddKeySet.get(i)).get(0),
                                    kOdd.get(kOddKeySet.get(j)).get(1)};
                        }else if(j==i){
                            continue;
                        }
                        if(kOddKeySet.get(i) + kOddKeySet.get(j) == target){
                            return new int[] {kOdd.get(kOddKeySet.get(i)).get(0),
                                    kOdd.get(kOddKeySet.get(j)).get(0)};
                        }
                    }
                }
                for(int i=0; i<kEvenKeySet.size();i++){
                    for(int j =0; j<kEvenKeySet.size();j++){
                        if(j==i && kEven.get(kEvenKeySet.get(i)).size()==2 &&
                                kEvenKeySet.get(i) + kEvenKeySet.get(j) == target
                        ){
                            return new int[] {kEven.get(kEvenKeySet.get(i)).get(0),
                                    kEven.get(kEvenKeySet.get(j)).get(1)};
                        }else if(j==i){
                            continue;
                        }
                        if(kEvenKeySet.get(i) + kEvenKeySet.get(j) == target){
                            return new int[] {kEven.get(kEvenKeySet.get(i)).get(0),
                                    kEven.get(kEvenKeySet.get(j)).get(0)};
                        }
                    }
                }
            }
            return new int[]{};
        }
    }

