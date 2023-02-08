public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        Deque<Character> d = wordToDeque(word);
        int left = 0;
        int right = d.size() - 1;
        while (left <= right) {
            if (d.get(left) != d.get(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int len = word.length();
        for (int i = 0; i < len/2; i++) {
            if (!cc.equalChars(word.charAt(i), word.charAt(len - i - 1))) {
                return false;
            }
        }
        return true;
    }


}
