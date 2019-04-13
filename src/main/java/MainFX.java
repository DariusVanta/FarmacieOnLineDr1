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
import UI.MedicamentController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("medicamentWindow.fxml"));
        Parent root = fxmlLoader.load();

        MedicamentValidator medicamentValidator = new MedicamentValidator();
        ClientValidator clientValidator = new ClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        MedicamentRepository medicamentRepository = new MedicamentRepository(medicamentValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        MedicamentService medicamentService = new MedicamentService(medicamentRepository);
        medicamentService.addOrUpdate("1","algocalmin","Terapia",10,true);
        medicamentService.addOrUpdate("2","Paracetamol","AntiIAsi",20,false);

        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, medicamentRepository);
        Console console = new Console(medicamentService, clientService, transactionService);

        MedicamentController medicamentController =  fxmlLoader.getController();
        medicamentController.setServices(medicamentService, clientService, transactionService);

        primaryStage.setTitle("Medicament manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }

    public static void main(String[] args) {


        //     ConsoleLimbajNatural console = new ConsoleLimbajNatural(medicamentService, clientService, transactionService);

       // console.run();
        launch(args);

    }


}
