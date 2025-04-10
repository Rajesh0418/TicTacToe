package CustomExceptions;

import java.util.Set;

public class CustomExceptionsHandler {

    // Validates if the player's choice is between 1 and 9
    public void validate(int playerChoice) throws InvalidOptionEnteredException {
        if (playerChoice < 1 || playerChoice > 9) {
            throw new InvalidOptionEnteredException("Invalid option. Please enter a number between 1 and 9.");
        }
    }

    // Checks if the selected spot is already occupied
    public void checkSpotOccupied(Set<Integer> occupiedSpots, int playerChoice) throws SpotOccupiedException {
        if (occupiedSpots.contains(playerChoice)) {
            throw new SpotOccupiedException("Sorry, this spot is already occupied.");
        }
    }
}
