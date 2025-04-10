package CustomExceptions;

// If the user enters a number greater than 9 or less than 1, this exception will be raised
public class InvalidOptionEnteredException extends RuntimeException {
    public InvalidOptionEnteredException(String s) {
        super(s);
    }
}
