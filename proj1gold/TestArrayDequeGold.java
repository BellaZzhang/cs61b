import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    // test add and remove methods
    //return values from remove methods only
    //same set of values
    //test remove last/first
    //add values by add first/last
    //test by removelast
    private StudentArrayDeque<Integer> D1 = new StudentArrayDeque<>();
    private ArrayDequeSolution<Integer> D2 = new ArrayDequeSolution<>();

    @Test
    public void testAddFirst() {
        String history = "\n";
        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(10);
            D1.addFirst(random);
            D2.addFirst(random);
            history += "addFirst(" + random + ")" + "\n";
        }
        for (int i = 0; i < 10; i++) {
            history += "removeFirst() \n";
            assertTrue(history, D1.removeFirst() == D2.removeFirst());
        }

        for (int i = 0; i < 10; i++) {
            int random = StdRandom.uniform(10);
            D1.addLast(random);
            D2.addLast(random);
            history += "addLast(" + random + ")" + "\n";
        }
        D1.printDeque();
        D2.printDeque();

        for (int i = 0; i < 10; i++) {
            history += "removeLast() \n";
            assertTrue(history, D1.removeLast() == D2.removeLast());
        }
    }



}
