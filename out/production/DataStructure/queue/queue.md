Working of Queue Data Structure
In queues, elements are stored and accessed in First In, First Out manner. That is, elements are added from the behind and removed from the front.

How to use Queue?
In Java, we must import java.util.Queue package in order to use Queue.

// LinkedList implementation of Queue
Queue<String> animal1 = new LinkedList<>();

// Array implementation of Queue
Queue<String> animal2 = new ArrayDeque<>();

// Priority Queue implementation of Queue
Queue<String> animal 3 = new PriorityQueue<>();

Here, we have created objects animal1, animal2 and animal3 of classes LinkedList, ArrayDeque and PriorityQueue respectively. These objects can use the functionalities of the Queue interface.

Methods of Queue
The Queue interface includes all the methods of the Collection interface. It is because Collection is the super interface of Queue.

Some of the commonly used methods of the Queue interface are:

add() - Inserts the specified element into the queue. If the task is successful, add() returns true, if not it throws an exception.
offer() - Inserts the specified element into the queue. If the task is successful, offer() returns true, if not it returns false.
element() - Returns the head of the queue. Throws an exception if the queue is empty.
peek() - Returns the head of the queue. Returns null if the queue is empty.
remove() - Returns and removes the head of the queue. Throws an exception if the queue is empty.
poll() - Returns and removes the head of the queue. Returns null if the queue is empty.


Priority Queue
The PriorityQueue class provides the functionality of the heap data structure. It implements the Queue interface.

The Java PriorityQueue class implements the Queue interface.

Unlike normal queues, priority queue elements are retrieved in sorted order.

Suppose, we want to retrieve elements in the ascending order. In this case, the head of the priority queue will be the smallest element. 
Once this element is retrieved, the next smallest element will be the head of the queue.

It is important to note that the elements of a priority queue may not be sorted. However, elements are always retrieved in sorted order.

Creating PriorityQueue
In order to create a priority queue, we must import the java.util.PriorityQueue package. 
Once we import the package, here is how we can create a priority queue in Java.

PriorityQueue<Integer> numbers = new PriorityQueue<>();
Here, we have created a priority queue without any arguments. In this case, the head of the priority queue is the smallest element of the queue. 
And elements are removed in ascending order from the queue.

However, we can customize the ordering of elements with the help of the Comparator interface. 

Methods of PriorityQueue
The PriorityQueue class provides the implementation of all the methods present in the Queue interface.

Insert Elements to PriorityQueue
add() - Inserts the specified element to the queue. If the queue is full, it throws an exception.
offer() - Inserts the specified element to the queue. If the queue is full, it returns false.

Other PriorityQueue Methods
Methods	Descriptions
contains(element)	Searches the priority queue for the specified element. If the element is found, it returns true, if not it returns false.
size()	Returns the length of the priority queue.
toArray()	Converts a priority queue to an array and returns it.