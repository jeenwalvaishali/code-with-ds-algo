package tree.traversal;

import javax.sound.midi.Soundbank;

public class BinaryTree {

    Node root;

    public BinaryTree(){
        root = null;
    }

    public static void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.item + "=>");
        inOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.item + "=>");
    }

    public static void preOrder(Node node){
        if(node == null){
            return;
        }

        System.out.print(node.item + "=>");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);

        System.out.println("Inorder traversal");
        inOrder(tree.root);

        System.out.println("\nPreorder traversal ");
        preOrder(tree.root);

        System.out.println("\nPostorder traversal");
        postOrder(tree.root);
    }
}
