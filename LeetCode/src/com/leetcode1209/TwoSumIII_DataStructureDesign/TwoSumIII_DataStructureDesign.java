package com.leetcode1209.TwoSumIII_DataStructureDesign;

import java.util.HashMap;
import java.util.Map;

//Design and implement a TwoSum class. It should support the following operations: add and find.
//
//add - Add the number to an internal data structure.
//find - Find if there exists any pair of numbers which sum is equal to the value.
//
//For example,
//add(1); add(3); add(5);
//find(4) -> true
//find(7) -> false
public class TwoSumIII_DataStructureDesign {
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public TwoSumIII_DataStructureDesign(){
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	}
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)) {
        	map.put(number, map.get(number)+1); 
        } else {
        	map.put(number, 1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key : map.keySet()) {
        	int another = value - key;
        	if(another==key && map.get(key)>1) {
        		return true;
        	} else if(another !=key && map.containsKey(another)) {
        		return true;
        	}
        }
        return false;
    }
}
