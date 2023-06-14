package linkedlist.questions;

public class lengthOfLinkedList {

    public static int getLength(Node head){
        int count = 0;
        Node temp = head;

        while (temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }


    public static void printList(Node head){
        while (head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(".");

    }

    public static void main(String[] args){
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        printList(head);
        int length = getLength(head);

        System.out.println("");
        System.out.println(length);
    }
}
