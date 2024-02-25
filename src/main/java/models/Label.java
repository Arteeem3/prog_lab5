package models;

import utility.Validatable;
import java.util.Objects;

/**
 * Лейбл
 */
public class Label implements Validatable {
    private final String name;

    public Label(String name) {
        this.name = name;
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        return !(name == null || name.isEmpty());
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Label address = (Label) o;
        return Objects.equals(name, address.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Лэйбл " + name;
    }
}