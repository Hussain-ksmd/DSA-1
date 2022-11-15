/*Optimized solution for the Count Complete Tree Nodes 

tags: Binary Search, Tree, DFS
time: O(n)
space: O(h)

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
Example:
Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
https://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees

Thoughts:
Complate tree: last level may not be complete
Can dfs to traverse the tree: countNodes(root.left) + countNodes(root.right) + 1;
However, time exceeds: we don't really need to go through all.
Check if the tree of current root is perfect binary tree. If so, Pow(2, height), otherwise, dfs
Time: O(h^2)
Note: Using Math.pow(2, x) will time out.

*/
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getLeftHeight(root) + 1;
        int rightDepth = getRightHeight(root) + 1;
        
        if (leftDepth == rightDepth) {
            return (2 << (leftDepth - 1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int getLeftHeight(TreeNode node) {
        int count = 0;
        while (node.left != null) {
            node = node.left;
            count++;
        }
        return count;
    }
    
    private int getRightHeight(TreeNode node) {
        int count = 0;
        while (node.right != null) {
            node = node.right;
            count++;
        }
        return count;
    }
}
