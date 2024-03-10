package commands;


import managers.CollectionManager;
import models.Ask;
import models.MusicBand;
import utility.Console;

/**
 * Команда 'add_if_max'. Добавляет новый элемент в коллекцию, если его цена выше максимальной.
 * @author Artem Sokolov
 */
public class AddIfMax extends Command {
    private final Console console;
    private final CollectionManager collectionManager;

    public AddIfMax(Console console, CollectionManager collectionManager) {
        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его цена превышает максимальную цену этой коллекции");
        this.console = console;
        this.collectionManager = collectionManager;
    }

    /**
     * Выполняет команду
     * @return Успешность выполнения команды.
     */
    @Override
    public boolean apply(String[] arguments) {
        try {
            if (!arguments[1].isEmpty()) {
                console.println("Неправильное количество аргументов!");
                console.println("Использование: '" + getName() + "'");
                return false;
            }

            console.println("* Создание нового MusicBand:");
            MusicBand d = Ask.askMusicBand(console, collectionManager.getFreeId());
            var maxnop = maxNumberOfParticipants();
            assert d != null;
            if (d.getNumberOfParticipants() > maxnop) {
                collectionManager.add(d);
                console.println("MusicBand успешно добавлен!");
            } else {
                console.println("MusicBand не добавлен, количество участников не максимальное (" + d.getNumberOfParticipants() + " < " + maxnop +")");
            }
            return true;
        } catch (Ask.AskBreak e) {
            console.println("Отмена...");
            return false;
        }
    }

    private Long maxNumberOfParticipants() {
        return collectionManager.getCollection().stream()
                .map(MusicBand::getNumberOfParticipants)
                .mapToLong(Long::longValue)
                .max()
                .orElse(-1);
    }
}