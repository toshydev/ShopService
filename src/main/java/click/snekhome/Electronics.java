package click.snekhome;

import java.util.Objects;

public class Electronics extends Product {
    private String manufacturer;
    private String model;
    public Electronics(String name) {
        super(name);
    }
    public Electronics(String name, String model) {
        this(name);
    }
    public Electronics(String name, String model, String manufacturer) {
        this(name, model);
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Electronics that = (Electronics) o;
        return Objects.equals(manufacturer, that.manufacturer) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), manufacturer, model);
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
