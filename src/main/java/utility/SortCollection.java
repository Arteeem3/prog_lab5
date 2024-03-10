//package utility;
//import models.*;
//
//import java.io.IOException;
//import java.util.Comparator;
//import java.util.LinkedHashSet;
//import java.util.NavigableSet;
//import java.util.TreeSet;
//
//public class SortCollection{
//    /**
//     *
//     * @author Artem Sokolov
//     *
//     */
//    private final LinkedHashSet<MusicBand> collection;
//
//    public SortCollection(LinkedHashSet collection){
//        this.collection = collection;
//    }
//
//    public void sort(String args) throws IOException {
//        Comparator<Coordinates> coordsC = Comparator
//                .comparing(Coordinates::getY, Comparator.naturalOrder())
//                .thenComparing(Coordinates::getX, Comparator.naturalOrder());
//
//        Comparator<Label> labelC = Comparator
//                .comparing(Label::getName, Comparator.naturalOrder());
//
//        Comparator<MusicBand> c = Comparator
//                .comparing(MusicBand::getLabel, labelC)
//                .thenComparing(MusicBand::getGenre, Comparator.naturalOrder())
//                .thenComparing(MusicBand::getNumberOfParticipants, Comparator.naturalOrder())
//                //.thenComparing(MusicBand::getCreationDate, Comparator.naturalOrder())
//                .thenComparing(MusicBand::getCoordinates, coordsC)
//                .thenComparing(MusicBand::getName, Comparator.naturalOrder())
//                .thenComparing(MusicBand::getId, Comparator.naturalOrder());
//
//        NavigableSet<MusicBand> sortedSet = new TreeSet<>(c);
//        sortedSet.addAll(collection);
//        collection.clear();
//        collection.addAll(sortedSet);
//    }
//
//    public void sortById(String args) throws IOException {
//        Comparator<MusicBand> c = Comparator
//                .comparing(MusicBand::getId, Comparator.naturalOrder());
//
//        NavigableSet<MusicBand> sortedSet = new TreeSet<>(c);
//        sortedSet.addAll(collection);
//        collection.clear();
//        collection.addAll(sortedSet);
//    }
//}