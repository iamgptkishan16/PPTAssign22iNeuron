/*
💡 Question-2

A Given a binary tree, the task is to flip the binary tree towards the right direction that is clockwise. See the below examples to see the transformation.

In the flip operation, the leftmost node becomes the root of the flipped tree and its parent becomes its right child and the right sibling becomes its left child and the same should be done for all left most nodes recursively.

Example1:

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a5f5bbbe-8607-4f17-9ab4-b31327ffa2d0/Untitled.png)

Example2:

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/063636b4-9f35-4524-b6d9-c97e30cac510/Untitled.png)

*/

package Java_DSA.Trees.Assignment22;
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

class FlipBinaryTree {
    public static TreeNode flipBinaryTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode flippedRoot = flipBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return flippedRoot;
    }

    public static void printBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Original binary tree:");
        printBinaryTree(root);

        TreeNode flippedRoot = flipBinaryTree(root);
        System.out.println("\nFlipped binary tree:");
        printBinaryTree(flippedRoot);
    }
}
