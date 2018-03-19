/**
 * En klasse av RuntimeExeptions som kastes når
 * man forsøker å hente et element fra en tom ArrayDeque.
 * @author Tord Kvifte - tkv015
 */
public class DequeEmptyException extends RuntimeException {

    public DequeEmptyException()
    {
        this (null);
    } // end default constructor
    public DequeEmptyException(String message)
    {
        super (message);
    }
}