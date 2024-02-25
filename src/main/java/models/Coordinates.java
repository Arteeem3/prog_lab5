package models;

import utility.Validatable;
/**
 * Класс координат.
 * @author Artem Sokolov
 */
public class Coordinates implements Validatable {
    private Double x; //Значение поля должно быть больше -202
    private Float y; //Максимальное значение поля: 852, Поле не может быть null

    public Coordinates (Double x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates(String s) {
        try {
            try { this.x = Double.parseDouble(s.split(";")[1]); } catch (NumberFormatException e) { }
            try { this.y = Float.parseFloat(s.split(";")[1]); } catch (NumberFormatException e) { }
        } catch (ArrayIndexOutOfBoundsException e) {}
    }

    public Double getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    /**
     * Валидирует правильность полей.
     * @return true если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if (y == null) return false;
        return x>-202 && y<=852;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinates that = (Coordinates) obj;
        return x.equals(that.x) && y.equals(that.y);
    }

    @Override
    public int hashCode() {
        return x.hashCode() + y.hashCode();
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }
}