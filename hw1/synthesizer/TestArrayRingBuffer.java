package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(14);
        arb.enqueue(93);
        assertEquals(arb.peek(), 14);
        arb.enqueue(982);
        assertEquals(arb.dequeue(), 14);
        assertEquals(arb.dequeue(), 93);
        assertEquals(arb.isFull(), false);
        assertEquals(arb.fillCount(), 1);
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
