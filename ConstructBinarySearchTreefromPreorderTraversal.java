/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
    int index = 1;
    for (;index < preorder.length; index ++) 
        if (preorder[index] > preorder[0]) break;
    if (index - 1 > 0) {
        int[] left = new int[index - 1];
        for (int i = 1; i < index; i ++)
            left[i - 1] = preorder[i];
        root.left = bstFromPreorder(left);
    }
    if (index < preorder.length) {
        int[] right = new int[preorder.length - index];
        for (int i = 0; i < right.length; i ++)
            right[i] = preorder[index + i];
        root.right = bstFromPreorder(right);
    }
    return root;
    }
}