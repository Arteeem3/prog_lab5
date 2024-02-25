package managers;

import models.MusicBand;


import java.time.LocalDateTime;
import java.util.*;

/**
 * Оперирует коллекцией.
 * @author Artem Sokolov
 */
public class CollectionManager {
    private int currentId = 1;
    private Map<Integer, MusicBand> musicBands = new HashMap<>();
    private LinkedHashSet<MusicBand> collection = new LinkedHashSet<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private final DumpManager dumpManager;
    public boolean isAscendingSort;
    private ArrayDeque<String> logStack = new ArrayDeque<String>();

    public CollectionManager(DumpManager dumpManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.dumpManager = dumpManager;
    }

    /**
     * @return коллекция.
     */
    public LinkedHashSet<MusicBand> getCollection() {
        return collection;
    }

    /**
     * @return Последнее время инициализации.
     */
    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    /**
     * @return Последнее время сохранения.
     */
    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    /**
     * Сохраняет коллекцию в файл
     */
    public void saveCollection() {
        dumpManager.writeCollection(collection);
        lastSaveTime = LocalDateTime.now();
    }

    /**
     * Получить MusicBand по ID
     */
    public MusicBand byId(int id) { return musicBands.get(id); }

    /**
     * Содержит ли колекции MusicBand
     */
    public boolean isСontain(MusicBand e) { return e == null || byId(e.getId()) != null; }

    /**
     * Получить свободный ID
     */
    public int getFreeId() {
        while (byId(++currentId) != null);
        return currentId;
    }

    /**
     * Добавляет MusicBand
     */
    public boolean add(MusicBand d) {
        if (d == null) return false;
        musicBands.put(d.getId(), d);
        collection.add(d);
        update();
        return true;
    }

    /**
     * @return true в случае успеха.
     */
    public boolean swap(long id, long repId) {
        var e = byId((int) id);
        var re = byId((int) repId);
        if (e == null) return false;
        if (re == null) return false;
        List<MusicBand> coll = new ArrayList<MusicBand>(collection);
        var ind = coll.indexOf(e);
        var rind = coll.indexOf(re);
        if (ind < 0) return false;
        if (rind < 0) return false;

        e.setId((int) repId);
        re.setId((int) id);

        musicBands.put(e.getId(), e);
        musicBands.put(re.getId(), re);

        update();
        return true;
    }

    /**
     * Удаляет MusicBand по ID
     */
    public boolean remove(int id) {
        var a = byId(id);
        if (a == null) return false;
        musicBands.remove(a.getId());
        collection.remove(a);
        update();
        return true;
    }

    /**
     * Фиксирует изменения коллекции
     */
    public void update() {
        ArrayList<MusicBand> array = new ArrayList<>(collection);
        Collections.sort(array);
    }


    /**
     * Создает транзакцию или добавляет операцию в транзакцию
     */
    public void addLog(String cmd, boolean isFirst) {
        if (isFirst)
            logStack.push("+");
        if (!cmd.equals(""))
            logStack.push(cmd);
    }



    /**
     * Очищает коллекцию.
     */
    public void clearCollection() {
        collection.clear();
    }


    /**
     * Загружает коллекцию из файла.
     * @return true в случае успеха.
     */
    public boolean loadCollection() {
        musicBands.clear();
        dumpManager.readCollection();
        lastInitTime = LocalDateTime.now();
        for (var e : collection)
            if (byId(e.getId()) != null) {
                collection.clear();
                return false;
            } else {
                if (e.getId()>currentId) currentId = e.getId();
                musicBands.put(e.getId(), e);
            }
        update();
        return true;
    }

    /**
     * Фиксирует изменения коллекции
     */

    @Override
    public String toString() {
        if (collection.isEmpty()) return "Коллекция пуста!";

        StringBuilder info = new StringBuilder();
        for (var musicBand : collection) {
            info.append(musicBand+"\n\n");
        }
        return info.toString().trim();
    }
}