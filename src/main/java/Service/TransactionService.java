package Service;

import Domain.Medicament;
import Domain.Client;
import Domain.Transaction;
import Repository.MedicamentRepository;
import Repository.ClientRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private TransactionRepository transactionRepository;
    private MedicamentRepository medicamentRepository;

    public TransactionService(TransactionRepository transactionRepository, MedicamentRepository medicamentRepository) {
        this.transactionRepository = transactionRepository;
        this.medicamentRepository = medicamentRepository;
    }

    public Transaction addOrUpdate(String id, String idMedicament, String idClientCard, int numberOfItems, String date, String time) {
        Transaction existing = transactionRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (idMedicament.isEmpty()) {
                idMedicament = existing.getIdMedicament();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdClientCard();
            }
            if (numberOfItems == 0) {
                numberOfItems = existing.getNumberOfItems();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

        Medicament medicamentSold = medicamentRepository.findById(idMedicament);
        if (medicamentSold == null) {
            throw new RuntimeException("There is no Pill/medicament/durg with the given id!");
        }
        double basePrice = medicamentSold.getPrice();
        double discount = 0;
        if (idClientCard != null && medicamentSold.isNeedRecipe()) {
            discount = 0.1; // 10% discount
        }

        Transaction transaction = new Transaction(id, idMedicament, idClientCard, numberOfItems, date, time, basePrice, discount);
        transactionRepository.upsert(transaction);
        return transaction;
    }

    public void remove(String id) {
        transactionRepository.remove(id);
    }

    public List<Transaction> getAll() {
        return transactionRepository.getAll();
    }
}
