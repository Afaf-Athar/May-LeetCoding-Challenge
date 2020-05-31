/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 

Example 1:



Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
*/
class Solution {
    
    // TC = O(A.length + B.length)
    // SC = O(A.length + B.length)
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0;
        int j = 0;
        
        List<int[]> list = new ArrayList();
        
        while(i < A.length && j < B.length) {
            if(A[i][1] < B[j][0]) i++;
            else if(B[j][1] < A[i][0]) j++;
            else if(A[i][1] < B[j][1]) {
                list.add(new int[]{Math.max(A[i][0], B[j][0]), A[i][1]});
                i++;
            } else {
                list.add(new int[] {Math.max(A[i][0], B[j][0]), B[j][1]});
                j++;
            }
        }
        
        return list.toArray(new int[list.size()][]);
    }
}