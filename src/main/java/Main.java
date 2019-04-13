import Domain.MedicamentValidator;
import Domain.ClientValidator;
import Domain.TransactionValidator;
import Repository.MedicamentRepository;
import Repository.ClientRepository;
import Repository.TransactionRepository;
import Service.MedicamentService;
import Service.ClientService;
import Service.TransactionService;
import UI.Console;
import javafx.application.Application;
import javafx.stage.Stage;

import UI.ConsoleLimbajNatural;

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
   //   Console console = new Console(medicamentService, clientService, transactionService);
       ConsoleLimbajNatural console = new ConsoleLimbajNatural(medicamentService, clientService, transactionService);
        console.run();
    }

    }
