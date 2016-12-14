/**
 * Created by Evan Otero
 * 11/16/16
 */

public class BeginFieldState implements State {
    private final CSVMachine csvMachine;

    public BeginFieldState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void quote(char c) {
        csvMachine.setState(csvMachine.getQuotedFieldState());
    }

    // Do not change state
    public void comma(char c) {
        csvMachine.fieldComplete();
    }

    public void other(char c) {
        csvMachine.addCharToField(c);
        csvMachine.setState(csvMachine.getUnquotedFieldState());
    }
}
