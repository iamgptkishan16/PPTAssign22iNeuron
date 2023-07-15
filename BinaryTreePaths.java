/*
💡 Question-3:

Given a binary tree, print all its root-to-leaf paths without using recursion. For example, consider the following Binary Tree.

Input:

        6
     /    \
    3      5
  /   \     \
 2     5     4
     /   \
    7     4

Output:

There are 4 leaves, hence 4 root to leaf paths -
  6->3->2
  6->3->5->7
  6->3->5->4
  6->5>4

*/

package Java_DSA.Trees.Assignment22;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTreePaths {
    public static void printRootToLeafPaths(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        stack.push(root);
        pathStack.push(String.valueOf(root.val));

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            String currentPath = pathStack.pop();

            if (current.left == null && current.right == null) {
                System.out.println(currentPath);
            }

            if (current.right != null) {
                stack.push(current.right);
                pathStack.push(currentPath + "->" + current.right.val);
            }

            if (current.left != null) {
                stack.push(current.left);
                pathStack.push(currentPath + "->" + current.left.val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Root-to-leaf paths:");
        printRootToLeafPaths(root);
    }
}
