package commands;

import managers.CollectionManager;
import models.MusicBand;
import utility.Console;
import utility.ExecutionResponse;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Команда 'clear'. Очищает коллекцию.
 * @author Artem Sokolov
 */
public class Clear extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Clear(Console console, CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        if (!arguments[1].isEmpty()) {
            console.println("Неправильное количество аргументов!");
            console.println("Использование: '" + getName() + "'");
            return false;
        }

        var isFirst = true;
        while (collectionManager.getCollection().size() > 0) {
            LinkedList<MusicBand> array = new LinkedList<>(collectionManager.getCollection());
            var musicBand = array.removeLast();
            collectionManager.remove(musicBand.getId());
            collectionManager.addLog("remove " + musicBand.getId(),isFirst);
            isFirst = false;
        }

        collectionManager.update();
        console.println("Коллекция очищена!");
        return true;
    }
}