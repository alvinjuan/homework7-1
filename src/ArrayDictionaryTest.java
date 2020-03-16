import org.junit.Test;

import java.lang.reflect.Array;

import static org.junit.Assert.*;

// got help from other students and peers

public class ArrayDictionaryTest {
    @Test
    public void demo() {
        int testSize = 5;
        ArrayDictionary dict = new ArrayDictionary(testSize);
        assertTrue(dict.add(2, 82));
        assertTrue(dict.add(4, 84));
        assertTrue(dict.add(7, 87));
        System.out.println(dict);
    }

    @Test
    public void remove() {
        // homework
        ArrayDictionary empty = new ArrayDictionary(0);
        ArrayDictionary dictionary = new ArrayDictionary(5);
        ArrayDictionary dictSecond = new ArrayDictionary(4);

        // empty dictionary
        assertFalse(empty.remove(3));

        dictionary.add(0, 10);
        dictionary.add(1, 30);
        dictionary.add(2, 40);
        assertTrue(dictionary.remove(1));
        assertFalse(dictionary.remove(1));  // test removed key
        assertTrue(dictionary.remove(0));   // test remove
        assertFalse(dictionary.remove(5));   // test remove (non existent)

        dictSecond.add(0, 12);
        dictSecond.add(1, 15);
        dictSecond.add(3, 37);
        dictSecond.add(9, 20);
        assertTrue(dictSecond.remove(1));   // test remove (collision)
        assertTrue(dictSecond.remove(0));   // test remove (non collision)
        assertFalse(dictSecond.remove(5));  // test remove (not in collision)
        assertFalse(dictSecond.remove(11)); // test remove (non existent key in collision)
    }

    @Test
    public void contains() {
        // homework
        ArrayDictionary dictEmpty = new ArrayDictionary(0);
        ArrayDictionary dictOne = new ArrayDictionary(1);
        ArrayDictionary dictTwo = new ArrayDictionary(2);
        ArrayDictionary dictThree = new ArrayDictionary(3);
        ArrayDictionary dictFour = new ArrayDictionary(4);

        // empty dictionary
        assertFalse(dictEmpty.contains(-1));
        assertFalse(dictEmpty.contains(0));
        assertFalse(dictEmpty.contains(1));

        // one input
        dictOne.add(0, 103);
        assertFalse(dictOne.contains(2));
        assertTrue(dictOne.contains(0));

        // two inputs
        dictTwo.add(0, 103);
        dictTwo.add(1, 105);
        assertTrue(dictTwo.contains(0));
        assertTrue(dictTwo.contains(1));
        assertFalse(dictTwo.contains(2));

        // three inputs
        dictThree.add(0, 103);
        dictThree.add(1, 105);
        assertFalse(dictThree.contains(3));
        dictThree.add(2, 206);
        assertTrue(dictThree.contains(1));

        // four inputs
        dictFour.add(0, 103);
        dictFour.add(1, 105);
        dictFour.add(2, 206);
        dictFour.add(4, 407);
        assertTrue(dictFour.contains(1));
        assertTrue(dictFour.contains(4));
        assertFalse(dictFour.contains(7));
        assertFalse(dictFour.contains(8));
    }
}
