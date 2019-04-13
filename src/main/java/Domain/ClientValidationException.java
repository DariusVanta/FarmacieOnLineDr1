package Domain;

public class ClientValidationException extends Exception {
    ClientValidationException(String errorMessage){
        super(errorMessage); //apeleaza constructorul din clasa Exeption
    }
}
