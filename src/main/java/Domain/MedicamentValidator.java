package Domain;

public class MedicamentValidator {

    public void validate(Medicament medicament) {
        if (medicament.getPrice() <= 0 ) {
            throw new RuntimeException("Price must be > 0.");
        }



    }
}
