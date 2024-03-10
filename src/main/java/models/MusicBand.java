package models;

import models.Coordinates;
import models.MusicGenre;
import utility.Element;
import utility.Validatable;

import java.awt.*;
import java.util.*;
import java.time.LocalDate;


public class MusicBand extends Element implements Validatable {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long numberOfParticipants; //Поле не может быть null, Значение поля должно быть больше 0
    private java.time.LocalDate establishmentDate; //Поле не может быть null
    private MusicGenre genre; //Поле может быть null
    private Label label; //Поле не может быть null

    public MusicBand(int id, String name, Coordinates coordinates, LocalDate creationDate, Long numberOfParticipants, LocalDate establishmentDate, MusicGenre genre, Label label) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.label = label;
    }

    public MusicBand(int id, String name, Coordinates coordinates, Long numberOfParticipants, MusicGenre genre, Label label) {
        this(id, name, coordinates, LocalDate.now(), numberOfParticipants, LocalDate.now(), genre, label);
    }

    /**
     * Валидирует правильность полей.
     * @return true, если все верно, иначе false
     */
    @Override
    public boolean validate() {
        if (id <= 0) return false;
        if (name == null || name.isEmpty()) return false;
        if (coordinates == null || !coordinates.validate()) return false;
        if (creationDate == null) return false;
        if (numberOfParticipants != null && numberOfParticipants <= 0) return false;
        if (establishmentDate == null) return false;
        if (label == null) return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public LocalDate getEstablishmentDate() {
        return establishmentDate;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public Label getLabel() {
        return label;
    }

    @Override
    public int compareTo(Element element) {
        return (int)(this.id - element.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicBand musicBand = (MusicBand) o;
        return id == musicBand.id && Objects.equals(name, musicBand.name) && Objects.equals(coordinates, musicBand.coordinates)
                && Objects.equals(creationDate, musicBand.creationDate) && Objects.equals(numberOfParticipants, musicBand.numberOfParticipants)
                && Objects.equals(establishmentDate, musicBand.establishmentDate) && Objects.equals(genre, musicBand.genre)
                && Objects.equals(label, musicBand.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coordinates, creationDate, numberOfParticipants, establishmentDate, genre, label);
    }

    @Override
    public String toString() {
        return "models.MusicBand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates.getX() + " ; " + coordinates.getY() +
                ", creationDate=" + creationDate +
                ", numberOfParticipants=" + numberOfParticipants +
                ", establishmentDate=" + establishmentDate +
                ", genre=" + genre +
                ", label=" + label.getName() +
                '}';
    }
}





