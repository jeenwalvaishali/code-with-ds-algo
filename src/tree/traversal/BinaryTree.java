package tree.traversal;

public class BinaryTree {

    TreeNode root;

    public BinaryTree(){
        root = null;
    }

    public static void inOrder(TreeNode node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.item + "=>");
        inOrder(node.right);
    }

    public static void postOrder(TreeNode node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.item + "=>");
    }

    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }

        System.out.print(node.item + "=>");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(9);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(6);

        System.out.println("Inorder traversal");
        inOrder(tree.root);

        System.out.println("\nPreorder traversal ");
        preOrder(tree.root);

        System.out.println("\nPostorder traversal");
        postOrder(tree.root);
    }
}
