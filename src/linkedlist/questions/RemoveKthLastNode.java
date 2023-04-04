package linkedlist.questions;
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
* */
public class RemoveKthLastNode {

    public static Node removeLastKthNode(Node head, int n){

        int length = 0;
        Node currentNode = head;

        while(currentNode != null){
            currentNode = currentNode.next;
            length++;
        }

        if(length < n){
            return head.next;
        }

        Node p1 = head;
        Node p2 = head;

        for (int i =0; i<n; i++){
            p1 = p1.next;
        }

        if (p1 == null) {
            return head.next;
        }


        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return head;
    }

    public static void printList(Node node){
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(
                "Linked List before removing nth last node : ");

        printList(head);

        head =  removeLastKthNode(head, 6);
        System.out.println("\n");
        System.out.println(
                "Linked List after removing nth last node : ");
        printList(head);


    }
}
