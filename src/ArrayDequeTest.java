import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class ArrayDequeTest {


    public static IDeque deque(){
        IDeque<String> deque = new ArrayDeque<>(4);
        String[] strings = {"knekt", "dame", "konge", "ess"};

        for (int i = 0; i < strings.length; i++) {
            deque.addFirst(strings[i]);
        }
        return deque;
    }

    public static String[] stringArray() {
        String[] strings = {"knekt", "dame", "konge", "ess"};

        return strings;
    }



    @org.junit.jupiter.api.Test
    void size() {
        IDeque<String> deque = deque();

        assertEquals(4, deque.size());
    }

    @org.junit.jupiter.api.Test
    void addFirst() {
        IDeque<String> deque = deque();

        assertEquals("ess", deque.peekFirst());
        assertEquals("knekt", deque.peekLast());
        assertThrows(DequeFullException.class, () -> deque.addFirst("en"));

    }

    @org.junit.jupiter.api.Test
    void pullFirst() {
        IDeque<String> deque = deque();

        String first = deque.pullFirst();
        String second = deque.pullFirst();
        assertEquals("ess", first);
        assertEquals("konge", second);

    }


    @org.junit.jupiter.api.Test
    void peekFirst() {
    }

    @org.junit.jupiter.api.Test
    void addLast() {
        IDeque<String> deque = deque();
        String[] strings = stringArray();
        for (int i = 0; i < strings.length; i++) {
            deque.addLast(strings[i]);
        }
    }

    @org.junit.jupiter.api.Test
    void pullLast() {
    }

    @org.junit.jupiter.api.Test
    void peekLast() {
    }

    @org.junit.jupiter.api.Test
    void contains() {
    }

    @org.junit.jupiter.api.Test
    void toArray() {
    }
}