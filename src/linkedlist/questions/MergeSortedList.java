package linkedlist.questions;
/*
You are given the heads of two sorted linked lists list1 and list2
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order
* */
public class MergeSortedList {

    public static Node mergeSortedList(Node list1, Node list2){
        Node headNode = new Node(-1);
        Node tailNode = headNode;

        while (list1 != null && list2!=null){
            if(list1.data <= list2.data){
               tailNode.next = list1;
               list1 = list1.next;
            }else {
                tailNode.next = list2;
                list2 = list2.next;
            }

            tailNode = tailNode.next;
        }

        if(list1 != null){
            tailNode.next = list1;
        }else if(list2 != null){
            tailNode.next = list2;
        }

        return headNode.next;
    }

    public static void printList(Node node){
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }


    public static void main(String[] args){
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(4);

        Node list2 = new Node(1);
        list2.next = new Node(3);
        list2.next.next = new Node(4);

        Node mergeList =  mergeSortedList(list1,list2);
        System.out.println("\n");
        System.out.println(
                "Linked List after removing duplicates : ");
        printList(mergeList);


    }
}
