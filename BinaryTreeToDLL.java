/*
💡 Question-1:

Given a Binary Tree (Bt), convert it to a Doubly Linked List(DLL). The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. The order of nodes in DLL must be the same as in Inorder for the given Binary Tree. The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.

Example:

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f9dda6ae-60b9-427b-990f-dc5b3117a5e3/Untitled.png)

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

class BinaryTreeToDLL {
    private static TreeNode prev;
    private static TreeNode head;

    public static TreeNode convertToDLL(TreeNode root) {
        if (root == null) {
            return null;
        }

        prev = null;
        head = null;
        convertToDLLHelper(root);

        return head;
    }

    private static void convertToDLLHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        convertToDLLHelper(root.left);

        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convertToDLLHelper(root.right);
    }

    public static void printDLL(TreeNode head) {
        if (head == null) {
            return;
        }

        TreeNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode dllHead = convertToDLL(root);
        System.out.println("Doubly Linked List (DLL):");
        printDLL(dllHead);
    }
}
