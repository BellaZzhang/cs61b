public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> queue = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            Character letter = word.charAt(i);
            queue.addLast(letter);
        }
        return queue;
    }

    public boolean isPalindrome(String word) {
        //compare first and last
        //repeat
        // Without wordToDeque
        /*for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;*/

        // With wordToDeque
        Deque d = wordToDeque(word);
        for (int i = 0; i < word.length(); i++) {
            if (d.get(i) != d.get(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        cc = new OffByOne();
        for (int i = 0; i < word.length(); i++) {
            char a = word.charAt(i);
            char b = word.charAt(word.length() - i - 1);
            if (i == word.length() - i - 1) {
                break;
            }
            if (!cc.equalChars(a, b)) {
                return false;
            }
        }
        return true;
    }


}
