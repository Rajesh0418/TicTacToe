package CustomExceptions;

// If the user enters a slot that is already occupied, this exception will be raised
public class SpotOccupiedException extends RuntimeException {
    public SpotOccupiedException(String s) {
        super(s);
    }
}
