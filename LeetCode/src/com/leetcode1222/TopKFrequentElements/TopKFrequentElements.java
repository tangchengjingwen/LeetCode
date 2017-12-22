package com.leetcode1222.TopKFrequentElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * @author tangc
 *
 */
public class TopKFrequentElements {
	//priorityQueue   time:O(klogn) space:O(n)
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		//重写compareto方法，改为降序
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = 
				new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
		}
		
		List<Integer> res =new ArrayList<>();
		while (res.size() < k) {
			Map.Entry<Integer, Integer> entry = maxHeap.poll();
			res.add(entry.getKey());
		}
		return res;
	}
	
	
	//TreeMap   time:O(klogn) space:O(n)
	public List<Integer> topKFrequent2(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (freqMap.containsKey(freq)) {
				freqMap.get(freq).add(num);
			} else {
				freqMap.put(freq, new LinkedList<>());
				freqMap.get(freq).add(num);
			}
		}
		
		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			//默认升序排列，所以去最后一个
			Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
			res.addAll(entry.getValue());
		}
		return res;
	}
	
	
	
	
	//bucket sort   time:O(n) space:O(n)
	public List<Integer> topKFrequent3(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		List<Integer>[] bucket = new List[nums.length + 1];
		
		for (int num : map.keySet()) {
			int freq = map.get(num);
			if (bucket[freq] == null) {
				bucket[freq] = new LinkedList<>();
			}
			bucket[freq].add(num);
		}
		
		List<Integer> res = new ArrayList<>();
		for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
			if (bucket[i] != null) {
				res.addAll(bucket[i]);
			}
		}
		return res;
	}
	
}
