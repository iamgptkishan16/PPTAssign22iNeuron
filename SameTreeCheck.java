/*
💡 Question-4:

Given Preorder, Inorder and Postorder traversals of some tree. Write a program to check if they all are of the same tree.

**Examples:**

Input : 

        Inorder -> 4 2 5 1 3
        Preorder -> 1 2 4 5 3
        Postorder -> 4 5 2 3 1
Output : 

Yes
Explanation : 

All of the above three traversals are of
the same tree 

                           1
                         /   \
                        2     3
                      /   \
                     4     5

Input : 

        Inorder -> 4 2 5 1 3
        Preorder -> 1 5 4 2 3
        Postorder -> 4 1 2 3 5
Output : 

No

*/

package Java_DSA.Trees.Assignment22;
class SameTreeCheck {
    public static boolean isSameTree(int[] preorder, int[] inorder, int[] postorder) {
        if (preorder.length != inorder.length || inorder.length != postorder.length) {
            return false;
        }
        int n = preorder.length;
        return isSameTreeHelper(preorder, inorder, postorder, 0, n - 1, 0, n - 1);
    }

    private static boolean isSameTreeHelper(int[] preorder, int[] inorder, int[] postorder,
                                            int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return true;
        }
        int rootValue = preorder[preStart];
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex < inStart || rootIndex > inEnd) {
            return false;
        }
        int leftSubtreeSize = rootIndex - inStart;
        return isSameTreeHelper(preorder, inorder, postorder,
                preStart + 1, preStart + leftSubtreeSize, inStart, rootIndex - 1)
                && isSameTreeHelper(preorder, inorder, postorder,
                preStart + leftSubtreeSize + 1, preEnd, rootIndex + 1, inEnd);
    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 5, 1, 3};
        int[] preorder = {1, 2, 4, 5, 3};
        int[] postorder = {4, 5, 2, 3, 1};
        System.out.println("Are the traversals of the same tree? " + isSameTree(preorder, inorder, postorder));

        inorder = new int[]{4, 2, 5, 1, 3};
        preorder = new int[]{1, 5, 4, 2, 3};
        postorder = new int[]{4, 1, 2, 3, 5};
        System.out.println("Are the traversals of the same tree? " + isSameTree(preorder, inorder, postorder));
    }
}
