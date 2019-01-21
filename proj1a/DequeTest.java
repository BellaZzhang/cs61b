import static org.junit.Assert.*;
import org.junit.Test;

public class DequeTest {

    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> DL = new LinkedListDeque<>();
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        String result = "";
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(10);
            DL.addFirst(random);
            DA.addFirst(random);
            result = random + " " + result;
        }
        System.out.println(result);
        DL.printDeque();
        DA.printDeque();
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> DL = new LinkedListDeque<>();
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        String result = "";
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(10);
            DL.addLast(random);
            DA.addLast(random);
            result += random + " ";
        }
        System.out.println(result);
        DL.printDeque();
        DA.printDeque();
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> DL = new LinkedListDeque<>();
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        DL.addLast(2);
        DL.addLast(5);
        DL.addLast(4);
        DL.addLast(9);
        DA.addLast(2);
        DA.addLast(5);
        DA.addLast(4);
        DA.addLast(9);
        assertTrue("LinkedList", 2 == DL.get(0));
        assertTrue("LinkedList recursive", 4 == DL.getRecursive(2));
        assertTrue("Array", 5 == DA.get(1));
    }

    @Test
    public void testSize() {
        LinkedListDeque<Integer> DL = new LinkedListDeque<>();
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        DL.addLast(2);
        DL.addLast(5);
        DL.addLast(4);
        DL.addLast(9);
        DA.addLast(2);
        DA.addLast(5);
        DA.addLast(4);
        DA.addLast(9);
        assertTrue("LinkedList", DL.size() == 4);
        assertTrue("Array", DA.size() == 4);
    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> DL = new LinkedListDeque<>();
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(10);
            DL.addLast(random);
            DA.addLast(random);
        }
        for (int i = 0; i < 10; i++) {
            assertTrue("LinkedList", DL.get(0) == DL.removeFirst());
        }
        for (int i = 0; i < 10; i++) {
            assertTrue("Array", DA.get(0) == DA.removeFirst());
        }
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> DL = new LinkedListDeque<>();
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(10);
            DL.addLast(random);
            DA.addLast(random);
        }
        for (int i = 0; i < 10; i++) {
            assertTrue("LinkedList", DL.get(DL.size() - 1) == DL.removeLast());
        }
        for (int i = 0; i < 10; i++) {
            assertTrue("Array", DA.get(DA.size() - 1) == DA.removeLast());
        }
    }

    @Test
    public void testResize() {
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        ArrayDeque<Integer> DA2 = new ArrayDeque<>();
        DA.addFirst(2);
        DA.addFirst(2);
        DA.addFirst(2);
        DA.removeLast();
        assertTrue(DA.getLength() == 4);
        DA2.addFirst(2);
        DA2.addFirst(2);
        DA2.addFirst(2);
        DA2.addFirst(2);
        DA2.addFirst(2);
        DA2.addFirst(2);
        DA2.removeLast();
        assertTrue(DA2.getLength() == 8);
    }

    @Test
    public void testUsageFactor() {
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        DA.addFirst(2);
        DA.addFirst(2);
        System.out.println(DA.getUsageFactor());
        assertTrue(DA.getUsageFactor() <= 0.25);
    }

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> DA = new ArrayDeque<>();
        assertTrue(DA.isEmpty() == true);
        DA.addFirst(2);
        assertTrue(DA.isEmpty() == false);
    }

}
