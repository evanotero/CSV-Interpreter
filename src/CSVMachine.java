import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evan Otero
 * 11/16/16
 */

public class CSVMachine {
    private final State BEGIN_FIELD,
            ERROR,
            QUOTED_FIELD,
            SEEN_QUOTE,
            UNQUOTED_FIELD;
    private final List<String> values = new ArrayList<>();
    private final StringBuilder outputField = new StringBuilder();
    private State currentState;

    public CSVMachine() {
        this.BEGIN_FIELD = new BeginFieldState(this);
        this.ERROR = new ErrorState(this);
        this.QUOTED_FIELD = new QuotedFieldState(this);
        this.SEEN_QUOTE = new SeenQuoteState(this);
        this.UNQUOTED_FIELD = new UnquotedFieldState(this);
        this.currentState = BEGIN_FIELD;
    }

    public void processChar(char c) {
        switch (c) {
            case '"':
                currentState.quote(c);
                break;
            case ',':
                currentState.comma(c);
                break;
            default:
                currentState.other(c);
                break;
        }
    }

    public void addCharToField(char c) {
        outputField.append(c);
    }

    public void fieldComplete() {
        if (currentState.equals(ERROR))
            values.add("ERROR");
        else
            values.add(outputField.toString());
        clearField();
    }

    private void clearField() {
        outputField.setLength(0);
    }

    /* Getters */
    public List<String> getRow() {
        if (outputField.length() != 0)
            fieldComplete();
        return values;
    }

    public State getBeginFieldState() {
        return BEGIN_FIELD;
    }

    public State getErrorState() {
        return ERROR;
    }

    public State getQuotedFieldState() {
        return QUOTED_FIELD;
    }

    public State getSeenQuoteState() {
        return SEEN_QUOTE;
    }

    public State getUnquotedFieldState() {
        return UNQUOTED_FIELD;
    }

    /* Setters */
    public void setState(State state) {
        this.currentState = state;
    }
}
