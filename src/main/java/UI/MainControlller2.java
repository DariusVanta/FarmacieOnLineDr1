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
