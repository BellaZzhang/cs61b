import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        Boolean a = palindrome.isPalindrome("noon", cc);

        assertTrue("normal",a == false);

        Boolean b = palindrome.isPalindrome("n", cc);
        assertTrue("single", b == true);

        Boolean c= palindrome.isPalindrome("ashjrt", cc);
        assertTrue("wrong", c == false);

        Boolean d= palindrome.isPalindrome("", cc);
        assertTrue("zero",d == true);

        Boolean e= palindrome.isPalindrome("flake", cc);
        assertTrue("offbyone",e == true);

        Boolean f= palindrome.isPalindrome("flabke", cc);
        assertTrue("offbyone",f == true);

        Boolean g= palindrome.isPalindrome("flaeilkjfbke", cc);
        assertTrue("offbyone",g == true);
    }
}
