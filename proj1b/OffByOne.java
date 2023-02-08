public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a, char b) {
        if (b-a == 1 || a-b == 1) {
            return true;
        } else {
            return false;
        }
    }

}
