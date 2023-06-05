package tree.traversal;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree(){
        root = null;
    }

    void insert(int item){
        root = insertItem(root, item);
    }

    public Node insertItem(Node root, int item) {
        if (root == null){
            root = new Node(item);
            return root;
        }

        if (item < root.item){
           root.left = insertItem(root.left, item);
        } else if (item > root.item) {
           root.right = insertItem(root.right, item);
        }
        return root;
    }

    void inOrder(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node root) {
        if (root != null){
            inOrderTraversal(root.left);
            System.out.print(root.item + " -> ");
            inOrderTraversal(root.right);
        }
    }

    void delete(int item){
        root = deleteItem(root, item);
    }

    private Node deleteItem(Node root, int item) {
        if (root == null){
            return root;
        }

        if(item < root.item){
            root.left = deleteItem(root.left, item);
        }else if (item > root.item){
            root.right = deleteItem(root.right, item);
        }else {
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }
            root.item = minValue(root.right);
        }
        return root;
    }


    /*If the node has both left and right children, it needs to find the inorder successor (the minimum value in the right subtree)
    to replace the node.
    It calls the minValue function to find the minimum value from the right subtree and assigns it to the current node's key.
    The minValue function takes a node root as input and returns the minimum value in the subtree rooted at that node.
    It finds the minimum value by traversing to the leftmost node in the subtree.*/

    private int minValue(Node root) {
        int min = root.item;
        while (root.left != null){
          min = root.left.item;
          root = root.left;
        }
        return min;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(8);
        tree.insert(3);
        tree.insert(1);
        tree.insert(6);
        tree.insert(7);
        tree.insert(10);
        tree.insert(14);
        tree.insert(4);

        System.out.print("Inorder traversal: ");
        tree.inOrder();

        System.out.println("\n\nAfter deleting 10");
        tree.delete(10);
        System.out.print("Inorder traversal: ");
        tree.inOrder();
    }
}
