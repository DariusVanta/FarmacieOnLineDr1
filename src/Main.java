import Domain.MedicamentValidator;
import Domain.Client;
import Domain.ClientValidator;
import Domain.TransactionValidator;
import Repository.MedicamentRepository;
import Repository.ClientRepository;
import Repository.TransactionRepository;
import Service.MedicamentService;
import Service.ClientService;
import Service.TransactionService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        MedicamentValidator medicamentValidator = new MedicamentValidator();
        ClientValidator clientValidator = new ClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        MedicamentRepository medicamentRepository = new MedicamentRepository(medicamentValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        MedicamentService medicamentService = new MedicamentService(medicamentRepository);
        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicamentRepository);

        Console console = new Console(medicamentService, clientService, transactionService);
        console.run();
    }
}
