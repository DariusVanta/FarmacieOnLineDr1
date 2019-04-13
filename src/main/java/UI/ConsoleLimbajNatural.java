
package UI;


import Domain.Client;
import Domain.Medicament;
import Domain.Transaction;
import Service.ClientService;
import Service.MedicamentService;
import Service.TransactionService;

import java.util.Scanner;

public class ConsoleLimbajNatural {

    private MedicamentService medicamentService;
    private ClientService clientService;
    private TransactionService transactionService;

    private Scanner scanner;

    public ConsoleLimbajNatural(MedicamentService medicamentService, ClientService clientService, TransactionService transactionService) {
        this.medicamentService = medicamentService;
        this.clientService = clientService;
        this.transactionService = transactionService;

        this.scanner = new Scanner(System.in);
    }


    private void showMenu() {
        System.out.println("Your option:");
        System.out.println("To Add or Update a medicament: addUpdMed, id, name, manufacturer, price, isNeedRecipe(true/false)");
        System.out.println("To Remove a medicament: remMed,id");
        System.out.println("To Read/show all pills: viewMed");
        System.out.println();
        System.out.println("To Add or Update a client: addUpdClient, id, lastName, firstName, CNP, dateOfBirth(dd:mm:yy), dateOfRegistration(dd:mm:yy)");
        System.out.println("To Remove a medicament: remClient,id");
        System.out.println("To Read/show all clients: viewCleint");
        System.out.println();
        System.out.println("To Add or Update a transaction: addUpdTrans,id, idMedicament, idClientCard, numberOfItems, date(dd.mm.yy), time(hh:mm)");
        System.out.println("To Remove a transaction: remTrans,id");
        System.out.println("To Read/show all clients: viewTrans");
        System.out.println();
        System.out.println("x. Exit");
    }
    public void run() {

            /*
        String denumire=rand[0];
        String tip=rand[1];
        int stocInitial=Integer.parseInt(rand[2]);
        int vandute=Integer.parseInt(rand[3]);
        int pretUnit=Integer.parseInt(rand[4]);
*/
        while (true) {
            showMenu();

            String line = scanner.nextLine();
            String[] options = line.split(" ");
            String option = options[0];
            String[] fields = options[1].split(",");

//String id =fields[0]; //
            //              String name = fields[1]; //
            //              String manufacturer = fields[2]; //


            //   private String id, name, manufacturer;
            //   private double price;
            //   private boolean needRecipe;


            switch (option) {

                case "addUpdTrans":
                    // String id =fields[0]; //
                    // String name = fields[1]; //
                    //String manufacturer = fields[2]; //
                    handleAddUpdateTransaction(fields);
                    break;
                case "remTrans":
                    handleRemoveTransaction(fields);
                    break;
                case "viewTrans":
                    handleViewTransactions(fields);
                    break;
                case "addUpdClient":
                    handleAddUpdateClient(fields);
                    break;
                case "remClient":
                    handleRemoveClient(fields);
                    break;
                case "viewCleint":
                    handleViewClients(fields);
                    break;
                case "addUpdMed":
                    handleAddUpdateMedicament(fields);
                    break;
                case "remMed":
                    handleRemoveMedicament(fields);
                    break;
                case "viewMed":
                    handleViewMedicament(fields);
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }

    }

    private void handleAddUpdateMedicament(String[] fields) {
        try {
            String id = fields[0]; //
            String name = fields[1]; //
            String manufacturer = fields[2]; //
            int price = Integer.parseInt(fields[3]);
            boolean isNeedRecipe = Boolean.valueOf(fields[4]); //
            medicamentService.addOrUpdate(id, name, manufacturer, price, isNeedRecipe);
            System.out.println("Drug/pill/medicament added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewMedicament(String[] fields) {
        for (Medicament medicament : medicamentService.getAll()) {
            System.out.println(medicament);
        }
    }

    private void handleRemoveMedicament(String[] fields) {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            medicamentService.remove(id);
            System.out.println("Drug/pill/medicament removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewClients(String[] fields) {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

    private void handleRemoveClient(String[] fields) {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            clientService.remove(id);
            System.out.println("Client removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClient(String[] fields) {
        try {
            String id = fields[0];
            String lastName = fields[1];
            String firstName = fields[2];
            String CNP = fields[3];
            String dateOfBirth = fields[4];
            String dateOfRegistration = fields[5];
            clientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewTransactions(String[] fields) {
        for (Transaction transaction : transactionService.getAll()) {
            System.out.println(transaction);
        }
    }

    private void handleRemoveTransaction(String[] fields) {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            transactionService.remove(id);
            System.out.println("Transaction removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateTransaction(String[] fields) {
        try {
            String id = fields[0]; //
            String idMedicament = fields[1]; //
            String idClientCard = fields[2]; //
            int numberOfItems = Integer.parseInt(fields[3]);
            // String numberOfItems = fields[3]; //
            String date = fields[4]; //
            String time = fields[5]; //
            Transaction transaction = transactionService.addOrUpdate(id, idMedicament, idClientCard, numberOfItems, date, time);
            System.out.println(String.format("Added transaction id=%s, paid price=%f, discount=%f%%", transaction.getId(), transaction.getDiscountedPrice(), transaction.getDiscount()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}