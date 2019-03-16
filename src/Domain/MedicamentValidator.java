package Domain;

public class CakeValidator {

    public void validate(Cake cake) {
        if (cake.getPrice() <= 0 || cake.getCalories() <= 50) {
            throw new RuntimeException("Price and calories must be > 0 and > 50 respectively.");
        }
    }
}
