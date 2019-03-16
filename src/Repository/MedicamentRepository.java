package Repository;

import Domain.Medicament;
import Domain.MedicamentValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentRepository {

    private Map<String, Medicamnet> storage = new HashMap<>();
    private MedicamentValidator validator;

    public MedicamentRepository(MedicamentValidator validator) {
        this.validator = validator;
    }

    public Medicament findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a medicament/drugg/pill if it already exists.
     * @param medicament the medicament/drugg/pill to add or update.
     */
    public void upsert(Medicament medicament) {
        validator.validate(medicament);
        storage.put(medicament.getId(), medicament);
    }

    /**
     * Removes a medicament/drugg/pill with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no medicament/drugg/pill with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no medicament/drugg/pill with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Medicament> getAll() {
        return new ArrayList<>(storage.values());
    }
}
