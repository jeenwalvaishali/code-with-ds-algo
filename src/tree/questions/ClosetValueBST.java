package tree.questions;

/*
Problem Description
Given a binary search tree (BST) and a target value, return the value in the BST that is closest to the target.

Example 1:
Input: root = [4,2,5,1,3], target = 3.714286
Output: 4

Example 2:
Input: root = [1], target = 4.428571
Output: 1
*/


public class ClosetValueBST {
    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        TreeNode current = root;

        while(current != null){
            if(Math.abs(current.val - target) < Math.abs(closet - target)){
                closet = current.val;
            }

            if(target < current.val){
                current = current.left;
            }else {
                current = current.right;
            }
        }

        return closet;
    }

    public static void main(String[] args) {
        // Creating a sample BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        ClosetValueBST closetValueBST = new ClosetValueBST();

        double target = 3.714286;

        // Using the iterative approach
        int closestIterative = closetValueBST.closestValue(root, target);
        System.out.println("Closest value (iterative): " + closestIterative);
    }
}
