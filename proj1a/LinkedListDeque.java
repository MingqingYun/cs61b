public class LinkedListDeque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;
        public Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
        public Node(Node p, Node n) {
            prev = p;
            next = n;
        }
    }

    /**private sentinel node*/
    private Node sentinel;
    private int size;

    /**Create an empty linked list deque*/
    public LinkedListDeque() {
        sentinel = new Node(null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    };
    /**Creates a deep copy of other*/
//    public LinkedListDeque(LinkedListDeque<T> other){
//        sentinel = new Node(null, null);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//
//        for (int i = 0; i < other.size(); i += 1){
//            addLast(other.get(i));
//        }

//    };

    /** Adds an item of type T to the front of deque.*/
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }
    /** Adds an item of type T to the back of deque.*/
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size ++;
    }
    /** Returns true if deque is empty, false otherwise*/
    public boolean isEmpty() {
        return size == 0;
    }
    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.println(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.*/
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T ret = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return ret;
    }
    /**Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast() {
        if (size==0){
            return null;
        }
        T ret = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return ret;
    }
    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque!
     */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    /**Same as get, but uses recursion.*/
    private T getRecursiveHelp(Node start, int index) {
        if (index == 0) {
            return start.item;
        } else {
            return getRecursiveHelp(start.next, index - 1);
        }
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelp(sentinel.next, index);
    }

}
