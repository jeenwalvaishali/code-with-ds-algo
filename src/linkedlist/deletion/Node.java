package linkedlist.deletion;

/*
In the Node class of a singly-linked list, we initialize the next field to null because it indicates that the current node is the last node in the list.
When we insert a new node at the end of the list, we set the next field of the current last node to the new node, effectively making it the new last node.
Since the next field of the new last node should be null, we initialize it as such when we create the new node.
*/

public class Node {

    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}
