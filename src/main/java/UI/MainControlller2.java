package UI;

import Domain.Medicament;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class MainControlller2 {
    public TableView tblMedicamente;
    public TableColumn colIdMedicament;
    public TableColumn colNameMedicament;
    public TableColumn colManufacturerMedicament;
    public TableColumn colPriceCake;
    public TableColumn colNeedRecipeMedicament;
    public TextField txtMedicamentID;
    public CheckBox chkNeedRecipe;
    public TextField txtMedicamentName;
    public TextField txtMedicamentManufacturer;
    public TextField txtMedicamentPrice;
    public Button btnAddMedicament;

    private MedicamentService medicamentService;
    private ClientService clientService;
    private TransactionService transactionService;

    public TableView tblTransaction;
    public TableColumn colIdTransaction;
    public TableColumn colIdMedicamentTransaction;
    public TableColumn colidClientCardTransaction;
    public TableColumn colDateTransaction;
    public TableColumn colTimeTransaction;
    public TableColumn colNumberOfItemsTransaction;
    public TableColumn colBasePriceTransaction;
    public TableColumn colDiscountTransaction;




    public TextField txtTransactionID;
    public TextField txtTransactionIdMedicament;
    public TextField txtTransactionIdClientCard;
    public TextField txtTransactionDate;
    public TextField txtTransactionTime;
    public TextField txtTransactionNumberOfItems;
    public TextField txtTransactionBasePrice;
    public TextField txtTransactionDiscount;


    public Button btnAddTransaction;
    public Button btnReadTransaction;
    public Button btnUpdateTransaction;
    public Button btnDeteleTransaction;

    public TableView tblClient;
    public TableColumn colIdClient;
    public TableColumn colIdMedicamentClient;
    public TableColumn colidClientCardClient;
    public TableColumn colDateClient;
    public TableColumn colTimeClient;
    public TableColumn colNumberOfItemsClient;
    public TableColumn colBasePriceClient;
    public TableColumn colDiscountClient;




    public TextField txtClientID;
    public TextField txtClientIdMedicament;
    public TextField txtClientIdClientCard;
    public TextField txtClientDate;
    public TextField txtClientTime;
    public TextField txtClientNumberOfItems;
    public TextField txtClientBasePrice;
    public TextField txtClientDiscount;


    public Button btnAddClient;
    public Button btnReadClient;
    public Button btnUpdateClient;
    public Button btnDeteleClient;


    private ObservableList<Medicament> medicamente = FXCollections.observableArrayList();

    public void setServices(MedicamentService medicamentService, ClientService clientService, TransactionService transactionService) {
        this.medicamentService = medicamentService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML
    private void initialize() {
        Platform.runLater(() -> {
            medicamente.addAll(medicamentService.getAll());
            tblMedicamente.setItems(medicamente);
        });
    }

    public void btnAddMedicamentClick(ActionEvent actionEvent) {
        try {
            String id = txtMedicamentID.getText();
            String name = txtMedicamentName.getText();
            String manufacturer = txtMedicamentManufacturer.getText();
            double price = Double.parseDouble(txtMedicamentPrice.getText());
            boolean needRecipe = chkNeedRecipe.isSelected();

           medicamentService.addOrUpdate(id,name,manufacturer,price,needRecipe);

            medicamente.clear();
            medicamente.addAll(medicamentService.getAll());
        } catch ( RuntimeException rex ){
            Common.showValidationError(rex.getMessage());
        }
    }
}
