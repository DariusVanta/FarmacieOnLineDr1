package Domain;

public class TransactionValidator {

    public void validate(Transaction transaction) {
        if (transaction.getNumberOfItems() <= 0) {
            throw new RuntimeException("The number of items must be at least 1.");
        }
    }
}
