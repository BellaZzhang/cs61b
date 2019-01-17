/** An Integer tester created by Flik Enterprises. */
import static org.junit.Assert.*;

import org.junit.Test;

public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    @Test
    public void testSame() {
        HorribleSteve A = new HorribleSteve();
        assertTrue(128 == 128);
        System.out.println("ye");
        assertTrue("wrong", isSameNumber(128, 128));
    }
}
