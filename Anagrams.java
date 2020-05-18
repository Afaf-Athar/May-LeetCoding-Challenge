/*
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab"class Solution {
 */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indexes = new ArrayList<>();
        Map<Character, Integer> pMap = new TreeMap<>();

        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map = new TreeMap<>();

        for (int i=0; i<p.length() && i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int i = p.length();
        while (i < s.length()) {
            int ind = i - p.length();         
            if (map.toString().equals(pMap.toString())) {
                indexes.add(ind);
            }
            
            map.put(s.charAt(ind), map.getOrDefault(s.charAt(ind), 0) - 1);
            if (map.get(s.charAt(ind)) <= 0) {
                map.remove(s.charAt(ind));
            }

            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            i++;
        }

        if (map.toString().equals(pMap.toString())) {
            indexes.add(i-p.length());
        }

        return indexes;
    }
}