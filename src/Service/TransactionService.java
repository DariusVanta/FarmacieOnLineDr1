package Service;

import Domain.Cake;
import Domain.Client;
import Domain.Transaction;
import Repository.CakeRepository;
import Repository.ClientRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    private TransactionRepository transactionRepository;
    private CakeRepository cakeRepository;

    public TransactionService(TransactionRepository transactionRepository, CakeRepository cakeRepository) {
        this.transactionRepository = transactionRepository;
        this.cakeRepository = cakeRepository;
    }

    public Transaction addOrUpdate(String id, String idCake, String idClientCard, int numberOfItems, String date, String time) {
        Transaction existing = transactionRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (idCake.isEmpty()) {
                idCake = existing.getIdCake();
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

        Cake cakeSold = cakeRepository.findById(idCake);
        if (cakeSold == null) {
            throw new RuntimeException("There is no cake with the given id!");
        }
        double basePrice = cakeSold.getPrice();
        double discount = 0;
        if (idClientCard != null && cakeSold.isSugarFree()) {
            discount = 0.1; // 10% discount
        }

        Transaction transaction = new Transaction(id, idCake, idClientCard, numberOfItems, date, time, basePrice, discount);
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
