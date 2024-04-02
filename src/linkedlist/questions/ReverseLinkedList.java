package linkedlist.questions;

public class ReverseLinkedList {

    public static Node reverseList(Node headNode){

        Node previousNode = null;
        Node currentNode = headNode;
        Node forwardNode = null;

        while (currentNode != null){
            forwardNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = forwardNode;
        }

        return previousNode;

    }

    public static void printList(Node headNode){
        Node currentNode = headNode;

        while (currentNode != null){
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }

        System.out.println("");
    }

    public static void main(String[] args){
        Node headNode = new Node(1);
        headNode.next = new Node(2);
        headNode.next.next = new Node(3);
        headNode.next.next.next= new Node(4);

        System.out.println("Original List");
        printList(headNode);

        System.out.println("Reversed List");
        headNode = reverseList(headNode);

        printList(headNode);
    }
}
