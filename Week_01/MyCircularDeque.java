//设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/   20.58~21.55
// TODO: 2021/1/24  同步问题???
public class MyCircularDeque {
    private Node first;
    private Node last;
    private int capacity;
    private int size;

    class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */

    //当链表中只有一个元素时，last == first
    //last节点与first互相不持有对方的引用
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = first;
        if (first != null) {//空队列
            first.prev = node;
        }
        first = node;

        if (last == null) {//空队列
            last = node;
        }
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.prev = last;
        if (last != null) {
            last.next = node;
        }

        last = node;
        if (first == null) {
            first = node;
        }

        size++;
        return true;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node nextNode = first.next;
        if (nextNode == null) {//队列中只有一个节点
            first = null;
            last = null;
        } else {
            nextNode.prev = null;
            first = nextNode;
        }
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node preNode = last.prev;
        if (preNode == null) {//队列中只有一个节点
            first = null;
            last = null;
        } else {
            preNode.next = null;
            last = preNode;
        }
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return first == null ? -1 : first.value;

    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return last == null ? -1 : last.value;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == capacity;
    }
}
