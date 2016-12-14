/**
 * Created by Evan Otero
 * 11/16/16
 */

public class SeenQuoteState implements State {
    private final CSVMachine csvMachine;

    public SeenQuoteState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void quote(char c) {
        csvMachine.addCharToField(c);
        csvMachine.setState(csvMachine.getQuotedFieldState());
    }

    public void comma(char c) {
        csvMachine.fieldComplete();
        csvMachine.setState(csvMachine.getBeginFieldState());
    }

    public void other(char c) {
        csvMachine.setState(csvMachine.getErrorState());
    }
}
