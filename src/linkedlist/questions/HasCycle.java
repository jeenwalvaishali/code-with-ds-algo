package linkedlist.questions;

public class HasCycle {

    public boolean hasCycle(Node head){
        if(head == null || head.next == null){
            return false;
        }

        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer == fastPointer;
    }
}
