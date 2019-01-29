package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(2);
        assertEquals(2, arb.peek());
    }

    @Test
    public void testDequeue() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        arb.enqueue(2);
        assertEquals(2, arb.dequeue());
    }

    @Test
    public void testCapacity() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
