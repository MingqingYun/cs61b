package synthesizer;
import synthesizer.AbstractBoundedQueue;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        /** Create new array with capacity elements. */
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()){
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1) % capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        T oldest = rb[first];
        fillCount -= 1;
        first = (first + 1) % capacity;
        return oldest;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        return rb[first];
    }


    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class ArrayRingBufferIterator implements Iterator<T> {
        private int pos;
        private int curNum;
        public ArrayRingBufferIterator() {
            pos = first;
            curNum = 0;
        }

        public boolean hasNext() {
            return curNum < fillCount;
        }

        public T next(){
            T retValue = rb[pos];
            pos = (pos + 1 ) % capacity;
            curNum++;
            return retValue;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }
}