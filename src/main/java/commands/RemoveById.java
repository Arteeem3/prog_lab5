package commands;

import managers.CollectionManager;
import utility.Console;

/**
 * Команда 'remove_by_id'. Удаляет элемент из коллекции.
 * @author Artem Sokolov
 */
public class RemoveById extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public RemoveById(Console console, CollectionManager collectionManager) {
        super("remove_by_id <ID>", "удалить элемент из коллекции по ID");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        if (arguments[1].isEmpty()) {
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }
        long id = -1;
        try { id = Long.parseLong(arguments[1].trim()); } catch (NumberFormatException e) { console.println("ID не распознан"); return false; }

        System.out.println(collectionManager.byId((int) id));
        System.out.println(!collectionManager.getCollection().contains(collectionManager.byId((int) id)));
        if (collectionManager.byId((int) id) == null || !collectionManager.getCollection().contains(collectionManager.byId((int) id))) {
            console.println("не существующий ID");
            return false;
        }
        collectionManager.remove((int) id);
        collectionManager.addLog("remove " + id, true);
        collectionManager.update();
        console.println("MusicBand успешно удалён!");
        return true;
    }
}