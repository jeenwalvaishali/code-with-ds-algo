package linkedlist.questions;

public class PalindromeLinkedList {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseLinkedList(slow.next);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }

    public static void printList(Node head){
        while (head != null){
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println(".");

    }

    public static void main(String[] args){
        Node head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        System.out.println("Given linked list");
        printList(head);
        head = reverseLinkedList(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        printList(head);

    }

}
