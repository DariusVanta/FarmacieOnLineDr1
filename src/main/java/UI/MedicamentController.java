package UI;

import Domain.Medicament;
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


public class MedicamentController {
    public TableView tblMedicamente;
    public TableColumn colIdMedicament;
    public TableColumn colNameMedicament;
    public TableColumn colManufacturerMedicament;
    public TableColumn colPriceMedicament;
    public TableColumn colNeedRecipeMedicament;
    public TextField txtMedicamentID;
    public CheckBox chkNeedRecipe;
    public TextField txtMedicamentName;
    public TextField txtMedicamentManufacturer;
    public TextField txtMedicamentPrice;
    public Button btnAddMedicament2;
    public Button btnReadMedicament2;
    public Button btnUpdateMedicament2;
    public Button btnDeteleMedicament2;


    private MedicamentService medicamentService;
    private ClientService clientService;
    private TransactionService transactionService;

    private ObservableList<Medicament> medicamentele = FXCollections.observableArrayList();
    private ActionEvent actionEvent;

    public void setServices(MedicamentService medicamentService, ClientService clientService, TransactionService transactionService) {
        this.medicamentService = medicamentService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            medicamentele.addAll(medicamentService.getAll());
            tblMedicamente.setItems(medicamentele);
        });
    }



    public void btnAddMedicament2Click(ActionEvent actionEvent) {
        this.actionEvent = actionEvent;
        try {
            String id = txtMedicamentID.getText();
            String name = txtMedicamentName.getText();
            String manufacturer = txtMedicamentManufacturer.getText();
            double price = Double.parseDouble(txtMedicamentPrice.getText());
            boolean needRecipe = chkNeedRecipe.isSelected();

            medicamentService.addOrUpdate(id, name, manufacturer, price, needRecipe);

            medicamentele.clear();
            medicamentele.addAll(medicamentService.getAll());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

        public void btnReadMedicament2Click(ActionEvent actionEvent) {
            try {
                String id = txtMedicamentID.getText();
                String name = txtMedicamentName.getText();
                String manufacturer = txtMedicamentManufacturer.getText();
                double price = Double.parseDouble(txtMedicamentPrice.getText());
                boolean needRecipe = chkNeedRecipe.isSelected();

                medicamentService.getAll();

                medicamentele.clear();
                medicamentele.addAll(medicamentService.getAll());
            } catch ( RuntimeException rex ){
                Common.showValidationError(rex.getMessage());
            }
        }
        public void btnUpdateMedicament2Click(ActionEvent actionEvent) {
            try {
              //  String id = txtMedicamentID.getText();
             //   String name = txtMedicamentName.getText();
            //   String manufacturer = txtMedicamentManufacturer.getText();
          //     double price = Double.parseDouble(txtMedicamentPrice.getText());
          //      boolean needRecipe = chkNeedRecipe.isSelected();

                medicamentService.getAll(); //addOrUpdate(id,name,manufacturer,price,needRecipe);

                medicamentele.clear();
                medicamentele.addAll(medicamentService.getAll());
            } catch ( RuntimeException rex ){
                Common.showValidationError(rex.getMessage());
            }
        }
        public void btnDeleteMedicament2Click(ActionEvent actionEvent) {
            try {
                String id = txtMedicamentID.getText();
                medicamentService.remove(id);

                medicamentele.clear();
                medicamentele.addAll(medicamentService.getAll());
            } catch ( RuntimeException rex ){
                Common.showValidationError(rex.getMessage());
            }
        }
    }


