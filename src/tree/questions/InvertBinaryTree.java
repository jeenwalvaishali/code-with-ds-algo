package tree.questions;
/*
Given the root of a binary tree, invert the tree, and return its root.
Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:
Input: root = [2,1,3]
Output: [2,3,1]
Example 3:
Input: root = []
Output: []
* */

public class InvertBinaryTree {

    TreeNode root;

    public InvertBinaryTree(){
        root = null;
    }

    public static TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void printTree(TreeNode root){

        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args){
        InvertBinaryTree binaryTree = new InvertBinaryTree();
        binaryTree.root = new TreeNode(4);
        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(7);
        binaryTree.root.left.left = new TreeNode(1);
        binaryTree.root.left.right = new TreeNode(3);
        binaryTree.root.right.left = new TreeNode(6);
        binaryTree.root.right.right = new TreeNode(9);

        printTree(binaryTree.root);

        System.out.println("\n");

//        invertTree(binaryTree.root);
//
//        printTree(binaryTree.root);


    }
}
