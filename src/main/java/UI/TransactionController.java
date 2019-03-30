package UI;

import Domain.Medicament;
import Domain.Transaction;
import Service.MedicamentService;
import Service.ClientService;
import Service.TransactionService;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;

//private String id, idMedicament, idClientCard, date, time;
//private int numberOfItems;
//private double basePrice;
//private double discount; -->

public class TransactionController {
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



    private MedicamentService medicamentService;
    private ClientService clientService;
    private TransactionService transactionService;

    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    public void setServices(MedicamentService medicamentService, ClientService clientService, TransactionService transactionService) {
        this.medicamentService = medicamentService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            transactions.addAll(transactionService.getAll());
            tblTransaction.setItems(transactions);
        });
    }

    //private String id, idMedicament, idClientCard, date, time;
//private int numberOfItems;
//private double basePrice;
//private double discount; -->

    public void btnAddtransactionClick(ActionEvent actionEvent) {
        try {
            String id = txtTransactionID.getText();
            String name = txtTransactionIdMedicament.getIdMedicament();
            String manufacturer = txtMedicamentManufacturer.getText();
            double price = Double.parseDouble(txtMedicamentPrice.getText());
            double discount = Double.parseDouble(txtTransactionDiscount.getDiscount());
            boolean needRecipe = chkNeedRecipe.isSelected();

            transactionService.addOrUpdate(id, idMedicament, idClientCard, numberOfItems, date, time);

            transactions.clear();
            transactions.addAll(transactionService.getAll());
        } catch ( RuntimeException rex ){
            Common.showValidationError(rex.getMessage());
        }
    }
}

//private String id, idMedicament, idClientCard, date, time;
//private int numberOfItems;
//private double basePrice;
//private double discount; -->