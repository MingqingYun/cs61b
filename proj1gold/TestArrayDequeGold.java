import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Array;

public class TestArrayDequeGold {
    @Test
    public void randomTests() {
        StudentArrayDeque<Integer> testArray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> stdArray = new ArrayDequeSolution<>();
        String log = "";

        for (int i = 0; i < 1000; i++) {
            if (stdArray.size() == 0) {
                int addNum = StdRandom.uniform(1000);
                int frontOrBack = StdRandom.uniform(2);
                if (frontOrBack == 0) {
                    log = "Adding " + addNum + " to front\n";
                    testArray.addFirst(addNum);
                    stdArray.addFirst(addNum);
                } else {
                    log = "Adding " + addNum + " to back\n";
                    testArray.addLast(addNum);
                    stdArray.addLast(addNum);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNum = StdRandom.uniform(1000);
                Integer testRemoveNumber = 1;
                Integer stdRemoveNumber = 1;
                switch(x){
                    case 0:
                        log = log + "Adding " + addNum + " to front\n";
                        testArray.addFirst(addNum);
                        stdArray.addFirst(addNum);
                        break;
                    case 1:
                        log = log + "Adding " + addNum + " to back\n";
                        testArray.addLast(addNum);
                        stdArray.addLast(addNum);
                        break;
                    case 2:
                        log = log + "Removing front\n";
                        testRemoveNumber = testArray.removeFirst();
                        stdRemoveNumber = stdArray.removeFirst();
                        break;
                    case 3:
                        log = log + "Removing last\n";
                        testArray.removeLast();
                        stdArray.removeLast();
                        break;
                    default:
                }
                assertEquals(log, testRemoveNumber, stdRemoveNumber);
            }
        }
    }
}
