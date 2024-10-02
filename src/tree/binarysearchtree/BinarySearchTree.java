package tree.binarysearchtree;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree(){
        root = null;
    }

    public boolean insert(int value){
        TreeNode newNode = new TreeNode(value);
        if(root == null){
            root = newNode;
            return true;
        }

        TreeNode temp = root;
        while(true){
            if(newNode.value == temp.value){
                return false;
            }
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }

                temp = temp.left;
            }else {
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }

                temp = temp.right;
            }
        }
    }

}
