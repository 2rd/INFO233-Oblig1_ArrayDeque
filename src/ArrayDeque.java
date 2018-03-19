import java.util.Arrays;

/**
 * En arraybasert implementasjon av IDeque-interfacet.
 *
 * @param <E> typen til tvekøen.
 * @author Tord Kvifte - tkv015
 */


public class ArrayDeque<E> implements IDeque<E> {

    private E[] deque;
    private int numOfEntries = 0;
    private static final int DEFAULT_CAPACITY = 50;
    private int firstIndex = 0, lastIndex = 0;

    public ArrayDeque(int capacity) {
        deque = (E[]) new Object[capacity];
    }

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Retunerer hvor mange elementer samlingen inneholder.
     *
     * @return Størrelsen på samlingen.
     */
    @Override
    public int size() {
        return this.numOfEntries;
    }

    /**
     * Legger til et element på begynnelsen av samlingen.
     *
     * @param elem Elementet som skal legges til.
     * @throws DequeFullException når det ikke er plass til
     *                            elementet.
     */
    @Override
    public void addFirst(E elem) throws DequeFullException {
        if (numOfEntries == deque.length) {
            throw new DequeFullException("Kan ikke legge til elementet " + elem + " når ArrayDeque er full.");
        }
        if (numOfEntries == 0) {
            deque[firstIndex] = elem;
        } else {
            firstIndex = (firstIndex - 1 + deque.length) % deque.length;
            deque[firstIndex] = elem;
        }

        numOfEntries++;
    }

    /**
     * Fjerner det første elementet fra samlingen og
     * returnerer det.
     *
     * @return Det første elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E pullFirst() throws DequeEmptyException {
        if (numOfEntries == 0) {
            throw new DequeEmptyException("Kan ikke kalle pullFirst i tom ArrayDeque");
        }
        E first = deque[firstIndex];
        deque[firstIndex] = null;
        firstIndex = (firstIndex + 1) % deque.length;
        numOfEntries--;

        return first;
    }

    /**
     * Retunerer det første elementet fra samlingen, men
     * fjerner det ikke.
     *
     * @return Det første elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E peekFirst() throws DequeEmptyException {
        if (numOfEntries == 0) {
            throw new DequeEmptyException("Kan ikke kalle peekFirst i tom ArrayDeque");
        }

        return deque[firstIndex];
    }

    /**
     * Legger til et element på slutten av samlingen.
     *
     * @param elem Elementet som skal legges til.
     * @throws DequeFullException når det ikke er plass til
     *                            elementet.
     */
    @Override
    public void addLast(E elem) throws DequeFullException {
        if (numOfEntries == deque.length) {
            throw new DequeFullException("Kan ikke legge til elementet " + elem + " når ArrayDeque er full.");
        }
        if (numOfEntries == 0) {
            deque[lastIndex] = elem;
        } else {
            lastIndex = (lastIndex + 1) % deque.length;
            deque[lastIndex] = elem;
        }

        numOfEntries++;
    }

    /**
     * Fjerner det siste elementet i samlingen og returnerer
     * det.
     *
     * @return Det siste elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E pullLast() throws DequeEmptyException {
        if (numOfEntries == 0) {
            throw new DequeEmptyException("Kan ikke kalle pullLast i tom ArrayDeque");
        }
        E last = deque[lastIndex];
        deque[lastIndex] = null;
        lastIndex = (lastIndex - 1 + deque.length) % deque.length;
        numOfEntries--;
        return last;
    }

    /**
     * Retunerer det siste elementet i samlingen, men
     * fjerner det ikke.
     *
     * @return Det siste elementet i samlingen.
     * @throws DequeEmptyException hvis samlingen er tom.
     */
    @Override
    public E peekLast() throws DequeEmptyException {
        if (numOfEntries == 0) {
            throw new DequeEmptyException("Kan ikke kalle peekLast i tom ArrayDeque");
        }
        return deque[lastIndex];
    }

    /**
     * Sjekker om et element er i samlingen.
     *
     * @param elem Elementet som kanskje er i samlingen.
     * @return retunerer true hvis elementet er i samlingen.
     */
    @Override
    public boolean contains(Object elem) {
        boolean result = false;
        for (int i = firstIndex; i != ((lastIndex + 1) % deque.length); i = ((i + 1) % deque.length)) {

            if (deque[i].equals(elem)) {

                result = true;
            }
        }
        return result;
    }

    /**
     * Retunerer en tabell med alle elementene i samlingen.
     *
     * @return En tabell med alle elementene i samlingen.
     */
    @Override
    public <T> Object[] toArray(T[] a) {
        int x = 0;
        Object[] result = Arrays.copyOf(this.deque, this.size(), a.getClass());
        for (int i = firstIndex; i != ((lastIndex + 1) % deque.length); i = ((i + 1) % deque.length)) {
            result[x] = deque[i];
            x++;
        }
        return result;
    }

    /**
     * Fjerner alle elementene fra samlingen.
     */
    @Override
    public void clear() {
        for (int i = firstIndex; i != ((lastIndex + 1) % deque.length); i = ((i + 1) % deque.length)) {
            deque[i] = null;
        }
        numOfEntries = 0;
        firstIndex = 0;
        lastIndex = 0;
    }


}
