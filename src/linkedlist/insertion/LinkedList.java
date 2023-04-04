package linkedlist.insertion;

public class LinkedList {

   static Node headNode;

    public static void insertAtEnd(int data){
        Node newNode = new Node(data);

       if(headNode == null){
           headNode = newNode;
           return;
       }

       Node currentNode = headNode;
       while(currentNode.next != null){
           currentNode = currentNode.next;
       }
       currentNode.next = newNode;
    }

    public static void insertAtFront(int data){
        Node newNode = new Node(data);
        newNode.next = headNode;
        headNode = newNode;
    }

    public static void printList(){
        Node node = headNode;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        headNode = new Node(2);
        headNode.next = new Node(3);
        headNode.next.next = new Node(4);
        headNode.next.next.next = new Node(5);


        System.out.println(
                "Linked List before inserting node : ");

        printList();

        insertAtEnd(6);
        insertAtFront(1);
        System.out.println("\n");
        System.out.println(
                "Linked List after inserting node : ");
        printList();
    }
}
