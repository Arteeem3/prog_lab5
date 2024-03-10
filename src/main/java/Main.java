import commands.*;

import managers.CollectionManager;
import managers.CommandManager;
import managers.DumpManager;

import models.MusicBand;

import utility.StandardConsole;
import utility.Runner;

public class Main {
    public static void main(String[] args) {
        var console = new StandardConsole();

        if (args.length == 0) {
            console.println("Введите имя загружаемого файла как аргумент командной строки");
            System.exit(1);
        }

        var dumpManager = new DumpManager(args[0], console);
        var collectionManager = new CollectionManager(dumpManager);
        if (!collectionManager.loadCollection()) {
            System.exit(1);
        }

        var commandManager = new CommandManager() {{
            register("help", new Help(console, this));
            register("history", new History(console, this));
            register("info", new Info(console, collectionManager));
            register("show", new Show(console, collectionManager));
            register("execute_script", new ExecuteScript(console));
            register("add", new Add(console, collectionManager));
            register("add_if_max", new AddIfMax(console, collectionManager));
            register("count_less_than_label", new CountLessThanLabel(console, collectionManager));
            register("update", new Update(console, collectionManager));
            register("remove_by_id", new RemoveById(console, collectionManager));
            register("clear", new Clear(console, collectionManager));
            register("save", new Save(console, collectionManager));
            register("exit", new Exit(console));

        }};

        new Runner(console, commandManager).interactiveMode();
    }
}