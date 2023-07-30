import java.util.Objects;

import static java.util.Objects.hash;

public class Toy {
    int id;
    String name;
    int quantity;
    int frequency;

    public Toy(String name, int quantity, int frequency) {
        id = Math.abs(hash(name));
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public Toy(Toy toy) {
        this.id = toy.getId();
        this.name = toy.getName();
        this.quantity = toy.getQuantity();
        this.frequency = toy.getFrequency();
    }

    @Override
    public String toString() {
        return String.format("id: %d,   name: %s,   quantity: %d,   frequency: %d\n", id, name, quantity, frequency);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Objects.equals(getName(), toy.getName());
    }
}

