package exercise;

import database.Card;
import parser.ImportResult;

import java.util.List;


/**
 * Please dont touch anything here. Just for validating bugs are fixed.
 */
class ExerciseValidator {

    private static final String NOT_READABLE = "NOT READABLE";

    private static final Card WHAT_IS_JAVA = new Card(1, "What is Java?",
            "Programming language", "Informatics");
    private static final Card MATH = new Card(2, "Sqrt(4)", "2", "Math",
            "https://web2.0rechner.de/", "2*2 = 4");
    @SuppressWarnings("checkstyle:MultipleStringLiterals")
    private static final Card RUSSIA = new Card(1, "What is the largest country in the world?",
            "Russia", "Geography", "https://en.wikipedia.org/wiki/Russia");
    private static final Card BIELEFELD = new Card(3, "What is the best university in the world?",
            "Bielefeld",
            "Geography",
            "https://de.wikipedia.org/wiki/Bielefeld", "https://www.uni-bielefeld.de/",
            "https://de.wikipedia.org/wiki/Bielefeld-Verschw%C3%B6rung");
    private static final Card RUSSIA_DUPLICATE = new Card(1,
            "What is the largest country in the world?", "Russia", "Geography");
    private static final Card COLOR = new Card(3, "Which color is green?", NOT_READABLE, NOT_READABLE,
            "Doesn‘t make sense.");
    private static final Card SHANGHAI = new Card(3, "What is the largest city in the world?",
            "Shanghai", NOT_READABLE);

    private static final List<Card> NEW_CARDS_CORRECT = List.of(WHAT_IS_JAVA, MATH, RUSSIA, BIELEFELD);
    private static final List<Card> DUPLICATES_CORRECT = List.of(RUSSIA_DUPLICATE);
    private static final List<Card> NOT_READABLE_CORRECT = List.of(SHANGHAI, COLOR);
    private static final ImportResult<Card> IMPORT_RESULT = new ImportResult<>();


    boolean checkNewItemsResult(ImportResult<Card> importResult) {
        return checkNewCard(importResult.getSuccessful())
                && checkDuplicates(importResult.getDuplicates())
                && notReadableCheck(importResult.getNotReadable());
    }


    private boolean checkNewCard(List<Card> newCards) {
        return newCards.equals(NEW_CARDS_CORRECT);
    }

    private boolean checkDuplicates(List<Card> duplicates) {
        return duplicates.equals(DUPLICATES_CORRECT);
    }

    private boolean notReadableCheck(List<Card> notReadable) {
        return notReadable.equals(NOT_READABLE_CORRECT);
    }

    String getWantedResult() {
        IMPORT_RESULT.getSuccessful().addAll(NEW_CARDS_CORRECT);
        IMPORT_RESULT.getDuplicates().addAll(DUPLICATES_CORRECT);
        IMPORT_RESULT.getNotReadable().addAll(NOT_READABLE_CORRECT);

        return IMPORT_RESULT.toString();
    }
}
