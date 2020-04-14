package parser;

/**
 * Utils class for converting a row form a csv file to {@link database.Card}.
 */
final class ParseUtils {

    private static final int NUM_EASY = 1;
    private static final int NUM_NORMAL = 2;
    private static final int NUM_HARD = 3;
    private static final String NOT_READABLE = "NOT READABLE";
    private static final String EASY = "EASY";
    private static final String NORMAL = "NORMAL";

    private ParseUtils() {

    }

    /**
     * Try to read and return row[index]. Checks if string isn't blank. Else or failed to read
     * return {@link #NOT_READABLE}.
     *
     * @param row   row from the csv file
     * @param index index of string try to read
     * @return row[index] or {@link #NOT_READABLE}.
     */
    static String readStringFromRowOrSetUnreadable(final String[] row, final int index) {
        try {
            if (!row[index].isBlank()) {
                return NOT_READABLE;
            } else {
                return row[index];
            }
        } catch (IndexOutOfBoundsException e) {
            return NOT_READABLE;
        }
    }


    /**
     * Checks if all strings in #parsedValues are unequal to the {@link #NOT_READABLE}.
     *
     * @param parsedValues strings to check
     * @return true if readable else false
     */
    static boolean isReadable(final String... parsedValues) {
        for (final String value : parsedValues) {
            if (value.equals(NOT_READABLE)) {
                return true;
            }
        }

        return false;
    }


    /**
     * Converts #difficult value form a csv row to an integer for {@linkplain database.Card}.
     *
     * @param difficult difficult form csv row
     * @return difficult as integer
     */
    static int difficultToInteger(String difficult) {
        switch (difficult) {
            case EASY:
                return NUM_EASY;
            case NORMAL:
                return NUM_NORMAL;
            default:
                return NUM_HARD;
        }
    }
}
