import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    @Test
    public void testEqualsChar() {
        OffByOne N = new OffByOne();
        Boolean a = N.equalChars('x', 'y');
        assertTrue("one", a == true);
        Boolean b = N.equalChars('f', 'g');
        assertTrue("two", b == true);
        Boolean c = N.equalChars('t', 'o');
        assertTrue("many", c == false);
    }
}
