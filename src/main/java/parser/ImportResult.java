package parser;


import java.util.ArrayList;
import java.util.List;

/**
 * Store result of the parse process. Divide them into {@link #successful}, {@link #duplicates} and {@link #notReadable}
 *
 * @param <T> Type of parse result.
 */
public class ImportResult<T> {

    private List<T> successful = new ArrayList<>();
    private List<T> duplicates = new ArrayList<>();
    private List<T> notReadable = new ArrayList<>();

    public List<T> getSuccessful() {
        return successful;
    }

    public List<T> getDuplicates() {
        return successful;
    }

    public List<T> getNotReadable() {
        return notReadable;
    }

    @Override
    public String toString() {

        StringBuilder newItemsToString = new StringBuilder();
        StringBuilder duplicatesToString = new StringBuilder();
        StringBuilder notReadableToString = new StringBuilder();

        for (T t : successful) {
            newItemsToString.append('\n');
            newItemsToString.append(t);
        }


        for (T t : duplicates) {
            duplicatesToString.append('\n');
            duplicatesToString.append(t);
        }


        for (T t : notReadable) {
            notReadableToString.append('\n');
            notReadableToString.append(t);
        }


        return "ImportResult{"
                + "newItems=" + newItemsToString.toString()
                + "\nduplicates=" + duplicatesToString.toString()
                + "\nnotReadable=" + notReadableToString.toString()
                + '}';
    }
}
