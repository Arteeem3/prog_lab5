package commands;

import managers.CollectionManager;
import models.Ask;
import models.MusicBand;
import utility.Console;
import utility.ExecutionResponse;

/**
 * Команда 'add'. Добавляет новый элемент в коллекцию.
 */
public class Add extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public Add(Console console, CollectionManager collectionManager) {
        super("add {element}", "добавить новый элемент в коллекцию");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды и сообщение об успешности.
     */
    @Override
    public boolean apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) {
                console.println("Неправильное количество аргументов!");
                console.println("Использование: '" + getName() + "'");
                return false;
            }

            console.println("* Создание нового Дракона:");
            MusicBand d = Ask.askMusicBand(console, collectionManager.getFreeId());

            if (d != null && d.validate()) {
                collectionManager.add(d);
                collectionManager.addLog("add " + d.getId(), true);
                console.println("Дракон успешно добавлен!");
                return true;
            } else {
                console.printError("Поля дракона не валидны! Дракон не создан!");
                return false;
            }
        } catch (Ask.AskBreak e) {
            console.println("Отмена...");
            return false;
        }
    }
}