package commands;

import managers.CollectionManager;
import models.Ask;
import utility.Console;

/**
 * Команда 'exit'. Завершает выполнение.
 * @author Artem Sokolov
 */
public class Exit extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Exit(Console console, CollectionManager collectionManager) {
        super("exit", "завершить программу (без сохранения в файл)");
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

        console.println("Сохранить коллекцию перед завершением программы? yes/no");
        var line = console.readln().trim().toUpperCase();
        if (line.equals("YES")) collectionManager.saveCollection();

        console.println("Завершение выполнения...");
        return true;
    }
}