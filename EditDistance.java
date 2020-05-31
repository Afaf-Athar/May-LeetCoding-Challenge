/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
    int n=word2.length();
    int[][] mem = new int[m][n];
    for(int[] arr: mem){
        Arrays.fill(arr, -1);
    }
    return calDistance(word1, word2, mem, m-1, n-1);
}
 
private int calDistance(String word1, String word2, int[][] mem, int i, int j){ 
    if(i<0){
        return j+1;
    }else if(j<0){
        return i+1;
    }
 
    if(mem[i][j]!=-1){
        return mem[i][j];
    }
 
    if(word1.charAt(i)==word2.charAt(j)){
        mem[i][j]=calDistance(word1, word2, mem, i-1, j-1);
    }else{
        int prevMin = Math.min(calDistance(word1, word2, mem, i, j-1), calDistance(word1, word2, mem, i-1, j));
        prevMin = Math.min(prevMin, calDistance(word1, word2, mem, i-1, j-1));
        mem[i][j]=1+prevMin;
    }
 
    return mem[i][j];
        
    }
}