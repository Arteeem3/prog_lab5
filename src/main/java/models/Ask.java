package models;

import utility.Console;

import java.util.NoSuchElementException;

public class Ask {
    public static class AskBreak extends Exception {}

    public static MusicBand askMusicBand(Console console, int id) throws AskBreak {
        try {
            String name;
            while (true) {
                console.print("name: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
            }
            var coordinates = askCoordinates(console);
            var numberOfparticipants = askNumberOfParticipants(console);
            var genre = askMusicGenre(console);
            var label = askLabel(console);

            return new MusicBand(id, name, coordinates, numberOfparticipants, genre, label);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Coordinates askCoordinates(Console console) throws AskBreak {
        try {
            Double x;
            while (true) {
                console.print("coordinates.x: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { x = Double.parseDouble(line); if (x>-202) break; }catch(NumberFormatException e) { }
                }
            }
            Float y;
            while (true) {
                console.print("coordinates.y: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { y = Float.parseFloat(line); if (y<=852) break; }catch(NumberFormatException e) { }
                }
            }
            return new Coordinates(x, y);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static MusicGenre askMusicGenre(Console console) throws AskBreak {
        try {
            MusicGenre r;
            while (true) {
                console.print("MusicGenre ("+MusicGenre.names()+"): ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try {
                        r = MusicGenre.valueOf(line); break;
                    } catch (NullPointerException | IllegalArgumentException  e) { }
                } else return null;
            }
            return r;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Label askLabel(Console console) throws AskBreak {
        try {
            String name;
            while (true) {
                console.print("Label: ");
                name = console.readln().trim();
                if (name.equals("exit")) throw new AskBreak();
                if (!name.isEmpty()) break;
            }
            return new Label(name);
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }

    public static Long askNumberOfParticipants(Console console) throws AskBreak {
        try {
            Long chislo;
            while (true) {
                console.print("NumberOfParticipants: ");
                var line = console.readln().trim();
                if (line.equals("exit")) throw new AskBreak();
                if (!line.equals("")) {
                    try { chislo = Long.parseLong(line); if (chislo>0) break; }catch(NumberFormatException e) { }
                }
            }
            return chislo;
        } catch (NoSuchElementException | IllegalStateException e) {
            console.printError("Ошибка чтения");
            return null;
        }
    }
}
