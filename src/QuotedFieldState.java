/**
 * Created by Evan Otero
 * 11/16/16
 */

public class QuotedFieldState implements State {
    private final CSVMachine csvMachine;

    public QuotedFieldState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void quote(char c) {
        csvMachine.setState(csvMachine.getSeenQuoteState());
    }

    // Do not change state
    public void comma(char c) {
        csvMachine.addCharToField(c);
    }

    // Do not change state
    public void other(char c) {
        csvMachine.addCharToField(c);
    }
}