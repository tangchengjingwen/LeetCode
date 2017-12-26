package com.leetcode1225.RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 * 
 * For example,
 * 
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 * @author tangc
 *tim:O(n) space:O(n)
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        
        for (int i = 0; i < s.length() -9; i++) {
        	String tmp = s.substring(i, i+10);
        	if (!seen.add(tmp)) {
        		repeated.add(tmp);
        	}
        }
        return new ArrayList<String>(repeated);
    }
}	
