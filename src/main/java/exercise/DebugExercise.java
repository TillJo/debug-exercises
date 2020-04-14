package exercise;

import database.Card;
import parser.CSVParser;
import parser.ImportResult;

import java.io.IOException;

/**
 * Main Class for debugging exercise. Please dont touch anything in this class.
 */
public final class DebugExercise {

    private static final String CARD_PATH = "src/main/resources/cards.csv";

    private DebugExercise() {

    }

    /**
     * Starts program. Use {@linkplain CSVParser} to parse csv file. Use {@linkplain ExerciseValidator} to check if
     * all bugs are fixed in parseResult..
     * Print result if not all bugs are fixed else print message "Exercise done!".
     *
     * @param args cmd arguments
     */
    public static void main(String[] args) {
        final CSVParser csvParser = new CSVParser();
        final ExerciseValidator exerciseValidator = new ExerciseValidator();
        ImportResult<Card> importResult = null;
        try {
            importResult = csvParser.importCardCsvFile(CARD_PATH);
        } catch (IOException ioE) {
            System.out.println("File not found!");
        }
        try {
            assert importResult != null;
            if (exerciseValidator.checkNewItemsResult(importResult)) {
                System.out.println("Exercise done!");
            } else {
                System.out.println("Not finished.");
                System.out.println("Your result of the parser:");
                System.out.println(importResult.toString());
                System.out.println("Result should be:");
                System.out.println(exerciseValidator.getWantedResult());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
