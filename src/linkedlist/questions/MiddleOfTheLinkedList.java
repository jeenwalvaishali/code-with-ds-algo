package linkedlist.questions;

public class MiddleOfTheLinkedList {

    public static Node middleList(Node headNode){
        if(headNode.next == null){
            return headNode;
        }

        Node slow = headNode;
        Node fast = headNode;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;

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
        headNode.next.next.next = new Node(4);
        headNode.next.next.next.next = new Node(5);

        System.out.println("Original List");
        printList(headNode);

        System.out.println("Middle List");
        headNode = middleList(headNode);

        printList(headNode);
    }
}
