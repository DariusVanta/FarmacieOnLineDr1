package Service;

import Domain.Medicament;
import Domain.Client;
import Repository.MedicamentRepository;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration) {
        Client existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (lastName.isEmpty()) {
                lastName = existing.getLastName();
            }
            if (firstName.isEmpty()) {
                firstName = existing.getFirstName();
            }
            if (CNP.isEmpty()) {
                CNP = existing.getCNP();
            }
            if (dateOfBirth.isEmpty()) {
                dateOfBirth = existing.getDateOfBirth();
            }
            if (dateOfRegistration.isEmpty()) {
                dateOfRegistration = existing.getDateOfRegistration();
            }
        }
        Client client = new Client(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
        repository.upsert(client);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }
}
