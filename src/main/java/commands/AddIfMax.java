//package commands;
//
//import managers.CollectionManager;
//import models.Ask;
//import models.MusicBand;
//import utility.Console;
//
//public class AddIfMax extends Command{
//    private final Console console;
//    private final CollectionManager collectionManager;
//
//    public AddIfMax(Console console, CollectionManager collectionManager) {
//        super("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции");
//        this.console = console;
//        this.collectionManager = collectionManager;
//    }
//
//    /**
//     * Выполняет команду
//     * @return Успешность выполнения команды.
//     */
//    @Override
//    public boolean apply(String[] arguments) {
//        try {
//            if (!arguments[1].isEmpty()) {
//                console.println("Неправильное количество аргументов!");
//                console.println("Использование: '" + getName() + "'");
//                return false;
//            }
//            console.println("* Создание нового MusicBand (add_if_max):");
//            MusicBand d = Ask.askMusicBand(console, collectionManager.getFreeId());
//
//            var maxValue = maxValue();
//            if (product.getPrice() > maxPrice) {
//                collectionManager.addToCollection(product);
//                console.println("Продукт успешно добавлен!");
//            } else {
//                console.println("Продукт не добавлен, цена не максимальная (" + product.getPrice() + " < " + maxPrice +")");
//            }
//            return true;
//
//        } catch (Ask.AskBreak e) {
//            console.println("Отмена...");
//            return false;
//        }
//    }
//}
