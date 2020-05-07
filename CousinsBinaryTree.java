/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.
Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
Note:
    1. The number of nodes in the tree will be between 2 and 100.
    2. Each node has a unique integer value from 1 to 100.
 */
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Node xNode = new Node();
    Node yNode = new Node();
    int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        preOrder(root, 0, 1);
        return xNode.parent != yNode.parent && xNode.depth == yNode.depth;
    }

    private void preOrder(TreeNode root, int parent, int depth) {
        if (root == null) {
            return;
        }

        if (root.val == x) {
            xNode.parent = parent;
            xNode.depth = depth;
        }
        if (root.val == y) {
            yNode.parent = parent;
            yNode.depth = depth;
        }
        preOrder(root.left, root.val, depth + 1);
        preOrder(root.right, root.val, depth + 1);
    }

    class Node {
        int parent;
        int depth;
    }
}