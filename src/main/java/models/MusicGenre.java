package models;

/**
 * Перечисление музыкальных жанров
 * @author Artem Sokolov
 */
public enum MusicGenre {
    ROCK,
    PROGRESSIVE_ROCK,
    BLUES,
    MATH_ROCK,
    PUNK_ROCK;

    /**
     * @return Строка со всеми элементами enum'а через запятую.
     */
    public static String names() {
        StringBuilder nameList = new StringBuilder();
        for (var MusicGenre : values()) {
            nameList.append(MusicGenre.name()).append(", ");
        }
        return nameList.substring(0, nameList.length()-2);
    }
}
