package linkedlist.questions;

import java.util.HashSet;

public class removeDuplicates {

    public static void removeDuplicate(Node node){
        HashSet<Integer> hashSet = new HashSet<>();
        Node previous = null;
        while (node != null){
            if (hashSet.contains(node.data)){
                previous.next = node.next;
            }else {
                hashSet.add(node.data);
                previous = node;
            }
            node = node.next;
        }
    }

    public static void removeDuplicateNoBuffer(Node head){
        Node currentNode = head;
        while (currentNode != null){
            Node runnerNode = currentNode;
            while (runnerNode.next != null){
                if (runnerNode.next.data == currentNode.data){
                    runnerNode.next = runnerNode.next.next;
                }else {
                    runnerNode = runnerNode.next;
                }
            }
            currentNode = currentNode.next;
        }

    }

    public static void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        Node node = new Node(10);
        node.next = new Node(12);
        node.next.next = new Node(11);
        node.next.next.next = new Node(11);
        node.next.next.next.next = new Node(12);
        node.next.next.next.next.next = new Node(11);
        node.next.next.next.next.next.next = new Node(10);

        System.out.println(
                "Linked List before removing duplicates : ");
        printList(node);

        removeDuplicateNoBuffer(node);
        System.out.println("\n");
        System.out.println(
                "Linked List after removing duplicates : ");
        printList(node);
    }
}
