/**
 * En klasse av RuntimeExeptions som kastes når
 * man forsøker å legge til noe inn i en full ArrayDeque.
 * @author Tord Kvifte - tkv015
 */

public class DequeFullException extends RuntimeException{

    public DequeFullException()
    {
        this (null);
    } // end default constructor
    public DequeFullException(String message)
    {
        super (message);
    }
}
