package commands;

import managers.CollectionManager;
import models.MusicBand;
import utility.Console;

import java.util.LinkedList;

public class CountLessThanLabel extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public CountLessThanLabel(Console console, CollectionManager collectionManager) {
        super("count_less_than_label label", "вывести количество элементов, значение поля label которых меньше заданного");
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

        collectionManager.count_less_than_label(arguments[1]);
        return true;
    }
}