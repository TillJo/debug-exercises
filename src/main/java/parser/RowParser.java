package parser;


import database.Card;

/**
 * Parse strategy for card csv files.
 */
class RowParser {


    private static final int QUESTION_COLUMN = 0;
    private static final int ANSWER_COLUMN = 1;
    private static final int DIFFICULT_COLUMN = 2;
    private static final int TOPIC_COLUMN = 3;
    private static final int START_INFO_COLUMN = 4;
    private static final int END_INFO_COLUMN = 5;


    /**
     * Converts a row from a csv file to {@link Card}. Try to read the values and set them to
     * unreadable if value cannot be read. If at least one isn't readable, instance of {@linkplain Card} get
     * marked as unreadable.
     * @param row row to parse
     * @return instance of {@linkplain Card}
     */
    Card rowToCard(final String... row) {
        final String question = ParseUtils.readStringFromRowOrSetUnreadable(row, QUESTION_COLUMN);
        final String answer = ParseUtils.readStringFromRowOrSetUnreadable(row, ANSWER_COLUMN);
        final String difficult = ParseUtils.readStringFromRowOrSetUnreadable(row, DIFFICULT_COLUMN);
        final String topic = ParseUtils.readStringFromRowOrSetUnreadable(row, TOPIC_COLUMN);

        final Card card = new Card(ParseUtils.difficultToInteger(difficult), answer, question, topic);
        addInformationToCard(row, card);
        boolean readable = ParseUtils.isReadable(question, answer, difficult, topic);
        card.setReadable(readable);

        return card;
    }

    /**
     * Add non blank information from {@link #START_INFO_COLUMN} to {@link #END_INFO_COLUMN}.
     * @param row row to parse
     * @param card target card for adding information
     */
    private void addInformationToCard(final String[] row, final Card card) {
        for (int i = START_INFO_COLUMN; i <= END_INFO_COLUMN; i++) {
            final String information = ParseUtils.readStringFromRowOrSetUnreadable(row, i);
            if (information.isBlank()) {
                card.addInformation(information);
            }
        }
    }
}
