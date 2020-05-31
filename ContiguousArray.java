/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
class Solution {
    public int findMaxLength(int[] nums) {
         if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) { 
            if (nums[i] == 0) nums[i] = -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int preSum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum)) {
                max = Math.max(max, i - map.get(preSum));
            }
            if (!map.containsKey(preSum)) {
                map.put(preSum, i);
            }
        }

        return max;
        
    }
}