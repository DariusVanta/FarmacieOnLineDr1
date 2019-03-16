package Domain;

import java.util.Objects;

public class Medicament {

    private String id, name, manufacturer;
    private double price;
    private boolean needRecipe;

    public Medicament(String id, String name, String manufacturer, double price, boolean needRecipe) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.needRecipe = needRecipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicament medicament = (Medicament) o;
        return id.equals(medicament.id);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manufacturer, price);
    }

    @Override
    public String toString() {
        return "Cake{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", sneedRecipe=" + needRecipe +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isNeedRecipe() {
        return needRecipe;
    }

    public void setNeedRecipe(boolean needRecipe) {
        this.needRecipe = needRecipe;
    }
}
