package Service;

import Domain.Medicament;
import Repository.MedicamentRepository;

import java.util.List;

public class MedicamentService {

    private MedicamentRepository repository;

    public MedicamentService(MedicamentRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(String id, String name, String manufacturer, double price, boolean needRecipe) {
        Cake existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (manufacturer.isEmpty()) {
                manufacturer = existing.getManufacurer();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Medicament medicament = new Medicament(id, name, manufacturer, price, needRecipe);
        repository.upsert(madicament);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Medicament> getAll() {
        return repository.getAll();
    }
}
