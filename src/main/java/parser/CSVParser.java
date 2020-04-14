package parser;

import database.Card;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

/**
 *
 */

public class CSVParser {

    private RowParser rowParser = new RowParser();

    /**
     * Read a csv file and parse every row to a card.
     * Checks if the result if readable or duplicate and add it to
     * corresponding list in #parseResult
     *
     * @param relativePath relative path of the csv file
     * @return #parseResult result of parsing process
     * @throws IOException if file isn't available
     */
    public ImportResult<Card> importCardCsvFile(final String relativePath) throws IOException {
        final CSVReader reader = new CSVReader(new FileReader(relativePath), ',', '"', 1);
        final List<String[]> rows = reader.readAll();
        final ImportResult<Card> importResult = new ImportResult<>();

        for (final String[] row : rows) {
            final Card card = rowParser.rowToCard(row);

            if (isDuplicate(card, importResult.getSuccessful())) {
                importResult.getDuplicates().add(card);
            } else if (card.isReadable()) {
                importResult.getSuccessful().add(card);
            } else {
                importResult.getNotReadable().add(card);
            }
        }

        reader.close();

        return importResult;
    }


    private boolean isDuplicate(Card cardToCheck, List<Card> successfulResults) {
        return successfulResults.contains(successfulResults);
    }
}
