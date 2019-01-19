import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {


    @Test
    public void testEqualsChar() {
        OffByN n = new OffByN(5);
        Boolean a = n.equalChars('a', 'f');
        assertTrue("one", a == true);

        Boolean b = n.equalChars('b', 'z');
        assertTrue("two", b == false);

        Boolean c = n.equalChars('f', 'a');
        assertTrue("one", c == true);
    }

}
