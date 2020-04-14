package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Represents a vocabulary card with question, answer, difficult, topics and additional information.
 */
public class Card {

    private int difficult;

    private List<String> additionalInformation = new ArrayList<>();

    private String answer;

    private String question;

    private List<String> topics = new ArrayList<>();

    private boolean readable = false;

    /**
     * @param difficult difficult of card
     * @param question  question of card
     * @param answer    answer of card
     */
    private Card(int difficult, String question, String answer) {
        this.difficult = difficult;
        this.answer = answer;
        this.question = question;
    }

    /**
     * @param difficult difficult of card
     * @param question  question of card
     * @param answer    answer of card
     * @param topic     topic of card
     */
    public Card(int difficult, String question, String answer, String topic) {
        this(difficult, question, answer);
        topics.add(topic);
    }

    /**
     * @param difficult difficult of card
     * @param question  question of card
     * @param answer    answer of card
     * @param topic     topic of card
     * @param infos     infos of card
     */
    public Card(int difficult, String question, String answer, String topic, String... infos) {
        this(difficult, question, answer, topic);
        for (String info : infos) {
            addInformation(info);
        }
    }

    /**
     * Add information to card if not added already.
     *
     * @param information information to add
     */
    public void addInformation(final String information) {
        if (!additionalInformation.contains(information)) {
            additionalInformation.add(information);
        }
    }

    public boolean isReadable() {
        return readable;
    }

    public void setReadable(boolean readable) {
        this.readable = readable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card card = (Card) o;
        return Objects.equals(question, card.question)
                && Objects.equals(answer, card.answer)
                && Objects.equals(difficult, card.difficult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answer);
    }

    @Override
    public String toString() {
        StringBuilder infos = new StringBuilder();
        StringBuilder topicsToString = new StringBuilder();
        for (String info : additionalInformation) {
            infos.append(info);
            infos.append("_");
        }


        for (String topic : topics) {
            topicsToString.append(topic).append(' ');
        }
        return "Card{"
                + "question='" + question + '\''
                + ", answer='" + answer + '\''
                + ", difficult=" + difficult
                + ", additionalInformation=" + infos.toString()
                + ", topics=" + topicsToString.toString()
                + '}';
    }
}
