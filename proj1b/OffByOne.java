public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a, char b) {
        return (b - a == 1 || a - b == 1);
    }
}
