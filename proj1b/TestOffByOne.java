import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('c', 'd'));
        assertTrue(offByOne.equalChars('F', 'G'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('c', 'c'));
        assertFalse(offByOne.equalChars('e', 'z'));
        assertFalse(offByOne.equalChars('z', 'Z'));
    }
}
