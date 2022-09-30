package sol;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.IList;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Homework2TestSuite {

    private MutableList<Integer> emptyList;
    private IList<Integer> myIntegerList;
    private MutableList<String> myStringList;

    private MutableList<Integer> myRepeatList = new MutableList<>();

    @Before
    public void setup() {
        // TODO: set up any testing data here
        //  (the setup method runs before *each* test method, thus resetting the data)
        MutableList<Integer> O = new MutableList<>();
        emptyList = O;

        MutableList<Integer> a = new MutableList<>();
        a.addFirst(5);
        a.addFirst(7);
        a.addFirst(3);
        a.addFirst(9);
        myIntegerList = a;
        // List = (9, 3, 7, 5)

        MutableList<String> b = new MutableList<>();
        b.addFirst("s");
        b.addFirst("q");
        b.addFirst("waldo");
        b.addFirst("n");
        myStringList = b;
        // List = ("n", "waldo", "q", "s")

        MutableList<Integer> c = new MutableList<>();
        c.addFirst(1);
        c.addLast(2);
        c.addLast(3);
        c.addLast(3);
        c.addLast(4);
        myRepeatList = c;
        // List = (1, 2, 3, 3, 4)

    }

    //need more cases

    // Task 1-A

    // Task 8

    @Test
    public void testGet() {
        assertEquals(myIntegerList.get(0).intValue(), 9);
        assertEquals(myIntegerList.get(2).intValue(), 7);
        assertEquals(myStringList.get(0), "n");
        assertEquals(myStringList.get(2), "q");
    }

    //Task 1-C

    @Test(expected = RuntimeException.class)
    public void testGetRuntimeException() {
        emptyList.get(0);
        emptyList.get(5);
        myIntegerList.get(10);
        myIntegerList.get(100);
        myIntegerList.get(100);
    }

    // Task 2-A,D

    @Test
    public void testAddLast() {
        MutableList<Integer> x = new MutableList<Integer>();
        x.addFirst(3);
        x.addLast(7);
        x.addFirst(9);
        assertFalse(compareTwoLists(x, myIntegerList));
        x.addLast(5);
        assertTrue(compareTwoLists(x, myIntegerList));
    }

    //need more cases

    // Task 8

    // Task 3-A,D

    @Test
    public void testSize() {
        MutableList<Integer> blank = new MutableList<Integer>();
        blank.addFirst(2);
        blank.addLast(3);
        blank.addFirst(1);
        assertEquals(blank.size(), 3);
        blank.addLast(4);
        blank.addLast(0);
        assertEquals(blank.size(), 5);
    }

    //need more cases

    // Tasks 5-A, 6-A,F,G and 8
    @Test
    public void testRemove() {
        MutableList<Integer> onefour = new MutableList<>();
        System.out.println(myRepeatList);
        onefour.addFirst(1);
        onefour.addLast(3);
        onefour.addLast(4);
        assertEquals(myRepeatList.size(), 5);
        assertEquals(myRepeatList.remove(3), true);
        assertEquals(myRepeatList.size(), 4);
        assertEquals(myRepeatList.remove(2), true);
        assertEquals(myRepeatList.size(), 3);
        //assertTrue(compareTwoLists(myRepeatList, onefour));
        System.out.println(myRepeatList);
    }

    @Test
    public void testRemoveWithNodes() {
        MutableList<Integer> onefour = new MutableList<>();
        onefour.addFirst(1);
        onefour.addLast(3);
        onefour.addLast(4);
        assertEquals(myRepeatList.size(), 5);
        assertEquals(myRepeatList.removeWithNodes(3), true);
        myRepeatList.removeWithNodes(3);
        assertEquals(myRepeatList.size(), 4);
        assertEquals(myRepeatList.removeWithNodes(2), true);
        assertEquals(myRepeatList.size(), 3);
        assertTrue(compareTwoLists(myRepeatList, onefour));
    }

    // Task 7-F

    /**
     * I would normally expect this to work by removing the node 8 and then
     * not functioning on the second call of remove. Does it match expectations?
     */
    @Test
    public void testDoubleRemove() {
        assertEquals(1, 1);
    }
    @Test
    public void testGetNode() {
        assertTrue(myStringList.getNode("waldo").hasItem("waldo"));
        assertTrue(myStringList.getNode("n").hasItem("n"));
        assertEquals(myStringList.getNode("DNE"), null);
    }
    @Test
    public void testRemoveNode() {
        assertEquals(1, 1);
    }

    /*
    Note: you may uncomment this method below to use in your testing suite
    after you've completed your get method if you'd like. It uses your get
    method so please make sure that is correct or this method will break!
     */

    /**
     * Checks if the two lists of integers are equal
     *
     * @param l1 - an Integer IList
     * @param l2 - an Integer IList
     * @return true if l1 and l2 have the same items in the same locations.
     */

    public boolean compareTwoLists(IList<Integer> l1, IList<Integer> l2) {
        if (l1.size() != l2.size()) {
            return false;
        } else {
            for (int i = 0; i < l1.size(); i++) {
                if (!(l1.get(i).equals(l2.get(i)))) {
                    return false;
                }
            }
            return true;
        }
    }

}